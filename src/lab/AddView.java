package lab;
import javax.swing.*;
        import java.awt.*;

public class AddView extends JFrame {

    JPanel labelPanel;
    JPanel textPanel;

    DataController DC;

    JTextField title;
    JTextField authorName;
    JTextField publishing;
    JTextField numberOfVolumes;
    JTextField circulation;


    JButton add;

    AddView(DataController DC){
        super("Add Window");
        this.DC = DC;
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add = new JButton("Add");
        createFields();
        createLabels();

        add(labelPanel);
        add(textPanel);
        add(add);

        setSize(1500, 1500);
        setResizable(false);
    }

    public void createLabels(){
        labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));

        JLabel title = new JLabel("title");
        JLabel authorName = new JLabel("authorName");
        JLabel publishing = new JLabel("publishing");
        JLabel numberOfVolumes = new JLabel("number of volumes");
        JLabel circulation = new JLabel("circulation");

        labelPanel.add(title);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(authorName);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(publishing);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(numberOfVolumes);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(circulation);
    }

    public void createFields(){
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.LINE_AXIS));

        final int WIDTH = 300;
        final int HEIGHT = 20;
        title = new JTextField();
        title.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        title.setMinimumSize(new Dimension(WIDTH,HEIGHT));

        authorName = new JTextField();
        authorName.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        authorName.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        publishing = new JTextField();
        publishing.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        publishing.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        numberOfVolumes = new JTextField();
        numberOfVolumes.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        numberOfVolumes.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        circulation = new JTextField();
        circulation.setMinimumSize(new Dimension(WIDTH,HEIGHT));
        circulation.setMaximumSize(new Dimension(WIDTH,HEIGHT));

        textPanel.add(title);
        textPanel.add(authorName);
        textPanel.add(publishing);
        textPanel.add(numberOfVolumes);
        textPanel.add(circulation);
    }

    public void addBook(){
        String tempTitle = title.getText();
        String tempAuthorName = authorName.getText();
        String tempPublishing = publishing.getText();
        int tempNumber = (numberOfVolumes.getText().equals("") ? 0 : Integer.parseInt(numberOfVolumes.getText()));
        int tempCirculation = (circulation.getText().equals("") ? 0 : Integer.parseInt(circulation.getText()));
        DC.add(new Book(tempTitle, tempAuthorName, tempPublishing, tempNumber, tempCirculation));
    }

}