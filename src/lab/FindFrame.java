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
            temp.setBooks(this.DC.FindBooks(list.get(0), list.get(1),list.get(2), Integer.parseInt(list.get(3)), Integer.parseInt(list.get(4)),Integer.parseInt(list.get(5)),Integer.parseInt(list.get(6)),Integer.parseInt(list.get(7)),Integer.parseInt(list.get(8)),choosePanel.getSelectedRadioButtonList()));
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

