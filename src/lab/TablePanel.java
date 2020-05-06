package lab;

import javax.swing.*;

public class TablePanel extends JPanel {
    DataController DC;

    JTable table;
    JPanel controlPane;
    JLabel count;
    JLabel page;

    int left;
    int right;
    int pageCounter;

    TablePanel(DataController DC){
        this.DC = DC;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        table = new JTable(10,6);

        makeControlButtons();
        createLabels();
        add(table);
        add(controlPane);
    }

    public void createLabels(){
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));

        JLabel title = new JLabel("title");
        JLabel authorName = new JLabel("author name");
        JLabel publishing = new JLabel("publishing");
        JLabel numberOfVolumes = new JLabel("number of volumes");
        JLabel circulation = new JLabel("circulation");
        JLabel totalVolumes = new JLabel( "total volumes");

        labelPanel.add(title);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(authorName);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(publishing);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(numberOfVolumes);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(circulation);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(totalVolumes);

        add(labelPanel);
    }

    void makeControlButtons(){
        left = 1;
        right = 10;
        pageCounter = 1;

        controlPane = new JPanel();
        controlPane.setLayout(new BoxLayout(controlPane, BoxLayout.LINE_AXIS));
        count = new JLabel("Books " + left + " - " + right);
        page = new JLabel("Page: " + pageCounter);

        JButton nextPage = new JButton("Next");
        nextPage.addActionListener(actionEvent -> {
            if(DC.isExists(right+1)) {
                left += 10;
                right += 10;
                pageCounter++;
                count.setText("Books " + left + " - " + right);
                page.setText("Page: " + pageCounter);
                showTable(DC);
            }
        });

        JButton prevPage = new JButton("Previous");
        prevPage.addActionListener(actionEvent -> {
            if(pageCounter > 1) {
                left -= 10;
                right -= 10;
                pageCounter--;
                count.setText("Books " + left + " - " + right);
                page.setText("Page: " + pageCounter);
                showTable(DC);
            }
        });

        controlPane.add(count);
        controlPane.add(Box.createHorizontalGlue());
        controlPane.add(page);
        controlPane.add(Box.createHorizontalGlue());
        controlPane.add(prevPage);
        controlPane.add(nextPage);
    }

    private void addBooks(int row, Book book){
        table.setValueAt(book.getTitleOfBook(), row, 0);
        table.setValueAt(book.getAuthorFullName(), row, 1);
        table.setValueAt(book.getPublishingHouse(), row, 2);
        table.setValueAt(book.getNumberOfVolumes(), row, 3);
        table.setValueAt(book.getCirculation(), row, 4);
        table.setValueAt(book.getTotalVolumes(), row, 5);
    }

    private void addEmpty(int row){
        table.setValueAt(" ", row, 0);
        table.setValueAt(" ", row, 1);
        table.setValueAt(" ", row, 2);
        table.setValueAt(" ", row, 3);
        table.setValueAt(" ", row, 4);
        table.setValueAt(" ", row, 5);
    }

    public void setBooks(DataController data){
        DC = data;
    }

    public  void showTable(DataController DC){
        int index = 0;
        for(int i = left-1; i < right; i++){
            if(DC.isExists(i)) {
                addBooks(index, DC.atIndex(i));
            }else{
                addEmpty(index);
            }
            index++;
        }
    }
}
