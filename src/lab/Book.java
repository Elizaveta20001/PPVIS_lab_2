package lab;

import java.util.ArrayList;
import java.util.List;

public class Book {


    private String titleOfBook;
    private String authorFullName;
    private String publishingHouse;
    private int numberOfVolumes;
    private int circulation;
    private int totalVolumes;

    public Book(){};
    public Book(String titleOfBook, String authorFullName, String publishingHouse, int numberOfVolumes,int circulation)
    {
        this.titleOfBook = titleOfBook;
        this.authorFullName=authorFullName;
        this.publishingHouse=publishingHouse;
        this.numberOfVolumes=numberOfVolumes;
        this.circulation=circulation;
        this.totalVolumes = numberOfVolumes*circulation;
    }

    public String getTitleOfBook()
    {
        return titleOfBook;
    }

    public void setTitleOfBook(String titleOfBook)
    {
        this.titleOfBook = titleOfBook;
    }

    public String getAuthorFullName()
    {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName)
    {
        this.authorFullName = authorFullName;
    }

    public String getPublishingHouse()
    {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse)
    {
        this.publishingHouse = publishingHouse;
    }

    public int getNumberOfVolumes()
    {
        return numberOfVolumes;
    }

    public void setNumberOfVolumes(int numberOfVolumes)
    {
        this.numberOfVolumes = numberOfVolumes;
    }

    public int getCirculation()
    {
        return circulation;
    }
    public void setCirculation(int circulation)
    {
        this.circulation = circulation;
    }
    public int getTotalVolumes() {
        return totalVolumes;

    }

    public void setTotalVolumes() {

        this.totalVolumes = this.numberOfVolumes * this.circulation;
    }


}

