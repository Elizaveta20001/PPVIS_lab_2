package lab;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class ChoosePanel extends JPanel{
    private JPanel textPanel;


    private JTextField title;

    private JTextField authorName;
    private JTextField publishing;
    private  JTextField minNumber;
    private  JTextField maxNumber;
    private JTextField minCirculation;
    private JTextField maxCirculation;
    private JTextField minTotal;
    private JTextField maxTotal;
    private List <JRadioButton> radioButtonList = new ArrayList<>();
    public String  getSelectedRadioButtonList()
    {
       for (JRadioButton radioButton : radioButtonList)
       {
           if(radioButton.isSelected())
           {
               return radioButton.getText();
           }
       }
        return null;
    }
    ChoosePanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createLabels();
        createText();
        createRadioButtons();
    }

    private void createLabels(){
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));

        JLabel titleLabel= new JLabel("title");
        titleLabel.setPreferredSize(new Dimension(300,20));

        JLabel authorNameLabel = new JLabel("author name");
        authorNameLabel.setPreferredSize(new Dimension(300,20));

        JLabel publishingLabel = new JLabel("publishing");
        publishingLabel.setPreferredSize(new Dimension(300,20));

        JLabel minNumberLabel = new JLabel("min number of volumes");
        minNumberLabel.setPreferredSize(new Dimension(300,20));

        JLabel maxNumberLabel = new JLabel( "max number of volumes");
        maxNumberLabel.setPreferredSize(new Dimension(300,20));

        JLabel minCirculationLabel = new JLabel("min circulation");
        minCirculationLabel.setPreferredSize(new Dimension(300,20));

        JLabel maxCirculationLabel = new JLabel( "max circulation");
        maxCirculationLabel.setPreferredSize(new Dimension(300,20));

        JLabel minTotalLabel = new JLabel("min total number of volumes");
        minTotalLabel.setPreferredSize(new Dimension(300,20));

        JLabel maxTotalLabel = new JLabel( "min total number of volumes");
        maxTotalLabel.setPreferredSize(new Dimension(300,20));

        labelPanel.add(titleLabel);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(authorNameLabel);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(publishingLabel);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(minNumberLabel);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(maxNumberLabel);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(minCirculationLabel);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(maxCirculationLabel);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(minTotalLabel);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(maxTotalLabel);
        add(labelPanel);
    }

    private void createRadioButtons()
    {
        JPanel radioButtons = new JPanel();
        radioButtons.setLayout(new BoxLayout(radioButtons,BoxLayout.Y_AXIS));

        JRadioButton titleButton = new JRadioButton();
        titleButton.setText("by title");

        JRadioButton authorNameButton = new JRadioButton();
        authorNameButton.setText("by author");

        JRadioButton authorNameAndPublishingButton = new JRadioButton();
        authorNameAndPublishingButton.setText("by author and publising");

        JRadioButton numberButton = new JRadioButton();
        numberButton.setText("by number");

        JRadioButton citculationButton = new JRadioButton();
        citculationButton.setText("by circulation");

        JRadioButton totalButton = new JRadioButton();
        totalButton.setText("by total");

        radioButtonList.add(titleButton);
        radioButtonList.add(authorNameButton);
        radioButtonList.add(authorNameAndPublishingButton);
        radioButtonList.add(numberButton);
        radioButtonList.add(citculationButton);
        radioButtonList.add(totalButton);

        for(JRadioButton radioButton : radioButtonList)
        {
            radioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(radioButton.isSelected())
                    {
                        for (JRadioButton radioButton1 : radioButtonList)
                        {
                            if(!radioButton1.getText().equals(radioButton.getText()))
                            {
                                radioButton1.setSelected(false);
                            }
                        }
                    }
                }
            });
        }
        radioButtons.add(titleButton);
        radioButtons.add(authorNameButton);
        radioButtons.add(authorNameAndPublishingButton);
        radioButtons.add(numberButton);
        radioButtons.add(citculationButton);
        radioButtons.add(totalButton);
        add(radioButtons);

    }
    private void createText(){
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.LINE_AXIS));

        final int WIDTH = 300;
        final int HEIGHT = 20;

        

        title = new JTextField();
        title.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        title.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        authorName = new JTextField();
        authorName.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        authorName.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        publishing = new JTextField();
        publishing.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        publishing.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        minNumber = new JTextField();
        minNumber.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        minNumber.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        maxNumber = new JTextField();
        maxNumber.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        maxNumber.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        minCirculation = new JTextField();
        minCirculation.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        minCirculation.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        maxCirculation = new JTextField();
        maxCirculation.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        maxCirculation.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        minTotal = new JTextField();
        minTotal.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        minTotal.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        maxTotal = new JTextField();
        maxTotal.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        maxTotal.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        textPanel.add(title);
        textPanel.add(authorName);
        textPanel.add(publishing);
        textPanel.add(minNumber);
        textPanel.add(maxNumber);
        textPanel.add(minCirculation);
        textPanel.add(maxCirculation);
        textPanel.add(minTotal);
        textPanel.add(maxTotal);
        add(textPanel);
    }

    public List<String> getBookFromFields(){
        List<String> result = new ArrayList<>();
        result.add(getTitle());
        result.add(getAuthorName());
        result.add(getPublishing());
        int minNumber = 0;
        int maxNumber = 0;
        if(!getMinNumber().equals("")){
            minNumber = Integer.parseInt(getMinNumber());
        }
        if(!getMaxNumber().equals("")){
            maxNumber = Integer.parseInt(getMaxNumber());
        }
        result.add(String.valueOf(minNumber));
        result.add(String.valueOf(maxNumber));
        int minCirculation = 0;
        int maxCirculaton = 0;
        if(!getMinCircilation().equals("")){
            minCirculation = Integer.parseInt(getMinCircilation());
        }
        if(!getMaxCirculation().equals("")){
            maxCirculaton = Integer.parseInt(getMaxCirculation());
        }
        result.add(String.valueOf(minCirculation));
        result.add(String.valueOf(maxCirculaton));
        int minTotal = 0;
        int maxTotal = 0;
        if(!getMinTotal().equals("")){
            minTotal = Integer.parseInt(getMinTotal());
        }
        if(!getMaxTotal().equals("")){
            maxTotal = Integer.parseInt(getMaxTotal());
        }
        result.add(String.valueOf(minTotal));
        result.add(String.valueOf(maxTotal));
        return result;
    }

    public String getTitle()
    {
        return title.getText();
    }

    public String getAuthorName()
    {
        return authorName.getText();
    }

    public String getPublishing()
    {
        return publishing.getText();
    }

    public String getMinNumber()
    {
        return minNumber.getText();
    }

    public String getMaxNumber()
    {
        return maxNumber.getText();
    }
    public String getMinCircilation()
    {
        return minCirculation.getText();
    }
    public String getMaxCirculation()
    {
        return maxCirculation.getText();
    }
    public String getMinTotal()
    {
        return minTotal.getText();
    }
    public String getMaxTotal()
    {
        return maxTotal.getText();
    }
}
