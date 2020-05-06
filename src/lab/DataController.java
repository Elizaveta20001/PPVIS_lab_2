package lab;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataController {

    private List<Book> tableData;



    DataController(){
        tableData = new ArrayList<Book>();
    }

    private List<Book> FindTemplate(String title, String authorName, String publishing, int minNumber, int maxNumber, int minCirculation, int maxCirculation,int minTotal,int maxTotal, String radioButton) {
        List<Book> temp = new ArrayList<>();
        for (Book tableDatum : tableData) {
            if(tableDatum.getTitleOfBook().equals(title) && radioButton.equals("by title"))
            {
                temp.add(tableDatum);
            }
            else if(tableDatum.getAuthorFullName().equals(authorName) && radioButton.equals("by author"))
            {
                temp.add(tableDatum);
            }
            else  if((tableDatum.getAuthorFullName().equals(authorName)) &&(tableDatum.getPublishingHouse().equals(publishing) && radioButton.equals("by author and publising")))
            {
                temp.add(tableDatum);
            }
            else  if((tableDatum.getNumberOfVolumes() >= minNumber && tableDatum.getNumberOfVolumes() <= maxNumber && radioButton.equals("by number")))
            {
                temp.add(tableDatum);
            }
            else  if((tableDatum.getCirculation() >= minCirculation && tableDatum.getCirculation() <= maxCirculation && radioButton.equals("by circulation")))
            {
                temp.add(tableDatum);
            }
            else  if((tableDatum.getTotalVolumes() >= minTotal && tableDatum.getTotalVolumes() <= maxTotal && radioButton.equals("by total")))
            {
                temp.add(tableDatum);
            }
        }
        return temp;
    }

    public List<Book> FindBooks(String title, String authorName, String publishing, int minNumber, int maxNumber, int minCirculation, int maxCirculation,int minTotal,int maxTotal,String radioButtun){

        return FindTemplate(title, authorName, publishing, minNumber, maxNumber,minCirculation,maxCirculation,minTotal,maxTotal,radioButtun);
    }

    public int DeleteBooks(String title, String authorName, String publishing, int minNumber, int maxNumber, int minCirculation, int maxCirculation,int minTotal,int maxTotal, String radioButton){

        List<Book> temp = FindTemplate(title, authorName, publishing, minNumber, maxNumber,minCirculation,maxCirculation,minTotal,maxTotal,radioButton);
        int amount = temp.size();
        tableData.removeAll(temp);
        return amount;
    }

    public void Add(Book book){
        tableData.add(book);
    }

    public void Read(String pathToFile) throws ParserConfigurationException, SAXException, IOException {
        Sax sax = new Sax();
        sax.parse(pathToFile);
        tableData = sax.getBooks();
    }

    public void Write(String pathToFile){
        Dom dom = new Dom();
        dom.setBook(tableData, pathToFile);
        dom.setBooks();
    }

    public Book atIndex(int index){
        return tableData.get(index);
    }

    public boolean isExists(int index){
        return index < tableData.size();
    }

    public void setBooks(List<Book> data){
        tableData = data;
    }
}
