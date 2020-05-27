package lab;

import javax.swing.*;
import java.util.List;

public class FindFrame extends JFrame {
    private DataController DC;

    private JButton findButton;

    private TablePanel tablePanel;

    private ChoosePanel choosePanel = new ChoosePanel();
    FindFrame(DataController DC){
        super("Find Book");
        this.DC = DC;
        setSize(1500, 500);
        setResizable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        findButton = new JButton("Find");
        findButton.addActionListener(actionEvent -> {
            List<String> list = choosePanel.getBookFromFields();
            DataController temp = new DataController();
            Filter filter = new Filter();
            filter.setFTitleOfBook(list.get(0));
            filter.setFAuthorName(list.get(1));
            filter.setFPublishing(list.get(2));
            filter.setFMinNumber(Integer.parseInt(list.get(3)));
            filter.setFMaxNumber(Integer.parseInt(list.get(4)));
            filter.setFMinCirculation(Integer.parseInt(list.get(5)));
            filter.setFMaxCirculation(Integer.parseInt(list.get(6)));
            filter.setFMinTotal(Integer.parseInt(list.get(7)));
            filter.setFMaxTotal(Integer.parseInt(list.get(8)));
            temp.setBooks(this.DC.findBooks(filter,choosePanel.getSelectedRadioButtonList()));
            tablePanel.setBooks(temp);
            tablePanel.showTable(temp);
        });

        tablePanel = new TablePanel(DC);
        JPanel pan = new JPanel();
        pan.add(findButton);

        add(choosePanel);
        add(pan);
        add(tablePanel);
    }

    public DataController getDC() {
        return DC;
    }

    public JButton getFindButton() {
        return findButton;
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    public ChoosePanel getChoosePanel() {
        return choosePanel;
    }
}

