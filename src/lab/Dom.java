package lab;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dom {
    String  pathTo;
    private static List<Book> books = new ArrayList<Book>();

    public static List<Book> getBooks() {
        return books;
    }
    public  void setBook(List<Book> book, String path){
        books = book;
        pathTo = path;
    }
    public  void addBook(Book book){
        books.add(book);
    }
    private static Node createBookElement(Document doc, String name,
                                          String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));

        return node;
    }

    private static Node createBook(Document document, String titleOfBooks, String authorFullNames, String publisingHouses, Integer numberOfVolume, Integer circulations,Integer totslVolume) {
        Element book = document.createElement("book");

        book.appendChild(createBookElement(document, "titleOfBook", titleOfBooks));

        book.appendChild(createBookElement(document, "authorFullName", authorFullNames));

        book.appendChild(createBookElement(document, "publisingHouse", publisingHouses));

        book.appendChild(createBookElement(document, "numberOfVolumes", numberOfVolume.toString()));

        book.appendChild(createBookElement(document, "circulation",circulations.toString()));

        book.appendChild(createBookElement(document,"totalVolumes",totslVolume.toString()));

        return book;
    }

    public void setBooks() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElementNS("", "Books");
            document.appendChild(root);
            for (Book book : books) {
                root.appendChild(createBook(document, book.getTitleOfBook(), book.getAuthorFullName(), book.getPublishingHouse(),book.getNumberOfVolumes(),book.getCirculation(),book.getTotalVolumes()));
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transf = null;
            try {
                transf = transformerFactory.newTransformer();
                transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transf.setOutputProperty(OutputKeys.INDENT, "yes");
                transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

                DOMSource source = new DOMSource(document);

                File myFile = new File(pathTo);
                StreamResult file = new StreamResult(myFile);

                transf.transform(source, file);
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}

