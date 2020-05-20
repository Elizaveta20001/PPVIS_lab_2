package lab;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class Sax {
    private String titleOfBook;
    private String authorFullName;
    private String publishingHouse;
    private int numberOfVolumes;
    private int circulation;
    private int totalOfVolumes;
    private String endEl;
    private final List<Book> books = new ArrayList<>();
    private Book book;

    public void parse(String file) {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bTitle = false;
                boolean bAuthorFullName = false;
                boolean bPublishingHouse = false;
                boolean bNumberOfVolumes = false;
                boolean bCirculation = false;
                boolean bTotalOfVolumes = false;

                public void startElement(String uri, String localName, String qName,
                                         Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("TITLEOFBOOK")) {
                        bTitle = true;
                    }
                    if (qName.equalsIgnoreCase("AUTHORFULLNAME")) {
                        bAuthorFullName = true;
                    }
                    if (qName.equalsIgnoreCase("PUBLISINGHOUSE")) {
                        bPublishingHouse = true;
                    }
                    if (qName.equalsIgnoreCase("NUMBEROFVOLUMES")) {
                        bNumberOfVolumes = true;
                    }
                    if (qName.equalsIgnoreCase("CIRCULATION")) {
                        bCirculation = true;
                    }
                    if (qName.equalsIgnoreCase("TOTALVOLUMES")) {
                        bTotalOfVolumes = true;
                    }
                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {
                    endEl = qName;
                }

                public void characters(char[] ch, int start, int length) throws SAXException {

                    if (bTitle) {
                        System.out.println("TITLEOFBOOK: " + new String(ch, start, length));
                        setTitleOfBook(new String(ch, start, length));

                        bTitle = false;
                        book = new Book();
                        book.setTitleOfBook(getTitleOfBook());

                    }
                    if (bAuthorFullName) {
                        System.out.println("AUTHORFULLNAME: " + new String(ch, start, length));
                        setAuthorFullName(new String(ch, start, length));

                        bAuthorFullName = false;
                        book.setAuthorFullName(getAuthorFullName());
                    }
                    if (bPublishingHouse) {
                        System.out.println("PUBLISINGHOUSE: " + new String(ch, start, length));
                        setPublishingHouse(new String(ch, start, length));

                        bPublishingHouse = false;
                        book.setPublishingHouse(getPublishingHouse());
                    }

                    if (bNumberOfVolumes) {
                        System.out.println("NUMBEROFVOLUNES : " + new String(ch, start, length));
                        setNumberOfVolumes(Integer.parseInt(new String(ch, start, length)));
                        bNumberOfVolumes = false;
                        book.setNumberOfVolumes(getNumberOfVolumes());

                    }

                    if (bCirculation) {
                        System.out.println("CIRCULATION : " + new String(ch, start, length));
                        setCirculation(Integer.parseInt(new String(ch, start, length)));
                        bCirculation = false;
                        book.setCirculation(getCirculation());

                    }
                    if (bTotalOfVolumes) {
                        System.out.println("TOTALVOLUMES : " + new String(ch, start, length));
                        setTotalOfVolumes();
                        bTotalOfVolumes = false;
                        book.setTotalVolumes();
                        books.add(book);

                    }


                }

            };

            saxParser.parse(file, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBooks(Book book) {
        this.books.add(book);
    }

    public String getEndElement() {
        return endEl;
    }

    public String getTitleOfBook() {
        return titleOfBook;
    }

    public void setTitleOfBook(String titleOfBook) {
        this.titleOfBook = titleOfBook;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getNumberOfVolumes() {
        return numberOfVolumes;
    }

    public void setNumberOfVolumes(int numberOfVolumes) {
        this.numberOfVolumes = numberOfVolumes;
    }
    public int getCirculation() {
        return circulation;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }
    public int getTotalOfVolumes() {
        return totalOfVolumes;
    }

    public void setTotalOfVolumes() {
        this.totalOfVolumes = numberOfVolumes * circulation;
    }
}

