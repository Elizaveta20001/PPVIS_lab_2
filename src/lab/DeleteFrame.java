package lab;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DeleteFrame extends JFrame {
    private DataController dataController;

    private ChoosePanel choosePanel = new ChoosePanel();

    private JButton delete;

    DeleteFrame(DataController dataController){
        super("Delete frame");
        this.dataController = dataController;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        init();
        setSize(1500, 1500);
        setResizable(false);
    }

    private void init() {
        delete = new JButton("Delete");
        delete.setMaximumSize(new Dimension(100, 20));

        add(choosePanel);
        add(delete);
    }

    public int deleteBooks(){
        List<String> list = choosePanel.getBookFromFields();
        //return  this.dataController.deleteBooks(list.get(0), list.get(1),list.get(2), Integer.parseInt(list.get(3)), Integer.parseInt(list.get(4)),Integer.parseInt(list.get(5)),Integer.parseInt(list.get(6)),Integer.parseInt(list.get(7)),Integer.parseInt(list.get(8)),choosePanel.getSelectedRadioButtonList());
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
        return this.dataController.deleteBooks(filter,choosePanel.getSelectedRadioButtonList());
    }

    public DataController getDataController() {
        return dataController;
    }

    public ChoosePanel getChoosePanel() {
        return choosePanel;
    }

    public JButton getDelete() {
        return delete;
    }
}

