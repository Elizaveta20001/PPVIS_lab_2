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

    private List<Book> findTemplate(Filter filter, String radioButton) {
        List<Book> temp = new ArrayList<>();
        for (Book tableDatum : tableData) {
            if(tableDatum.getTitleOfBook().equals(filter.getFTitleOfBook()) && radioButton.equals("by title"))
            {
                temp.add(tableDatum);
            }
            else if(tableDatum.getAuthorFullName().equals(filter.getFAuthorName()) && radioButton.equals("by author"))
            {
                temp.add(tableDatum);
            }
            else  if((tableDatum.getAuthorFullName().equals(filter.getFAuthorName())) &&(tableDatum.getPublishingHouse().equals(filter.getFPublishing()) && radioButton.equals("by author and publising")))
            {
                temp.add(tableDatum);
            }
            else  if((tableDatum.getNumberOfVolumes() >= filter.getFMinNumber() && tableDatum.getNumberOfVolumes() <= filter.getFMaxNumber() && radioButton.equals("by number")))
            {
                temp.add(tableDatum);
            }
            else  if((tableDatum.getCirculation() >= filter.getFMinCirculation() && tableDatum.getCirculation() <= filter.getFMaxCirculation() && radioButton.equals("by circulation")))
            {
                temp.add(tableDatum);
            }
            else  if((tableDatum.getTotalVolumes() >= filter.getFMinTotal() && tableDatum.getTotalVolumes() <= filter.getFMaxTotal() && radioButton.equals("by total")))
            {
                temp.add(tableDatum);
            }
        }
        return temp;
    }

    public List<Book> findBooks(Filter filter,String radioButtun){

        return findTemplate(filter,radioButtun);
    }

    public int deleteBooks(Filter filter, String radioButton){

        List<Book> temp = findTemplate(filter ,radioButton);
        int amount = temp.size();
        tableData.removeAll(temp);
        return amount;
    }

    public void add(Book book){
        tableData.add(book);
    }

    public void read(String pathToFile) throws ParserConfigurationException, SAXException, IOException {
        Sax sax = new Sax();
        sax.parse(pathToFile);
        tableData = sax.getBooks();
    }

    public void write(String pathToFile){
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
