package Object;

import java.util.Arrays;

public class Book {

    protected int id;
    protected String title, description, author;
    protected String[] catagory;
    protected int publishing_year;
    protected String publishing_company;

    public Book(int id, String title, String description, String author, String[] catagory, int publishing_year, String publishing_company) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.catagory = catagory;
        this.publishing_year = publishing_year;
        this.publishing_company = publishing_company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getCatagory() {
        return catagory;
    }

    public void setCatagory(String[] catagory) {
        this.catagory = catagory;
    }

    public int getPublishing_year() {
        return publishing_year;
    }

    public void setPublishing_year(int publishing_year) {
        this.publishing_year = publishing_year;
    }

    public String getPublishing_company() {
        return publishing_company;
    }

    public void setPublishing_company(String publishing_company) {
        this.publishing_company = publishing_company;
    }

    @Override
    public String toString() {
        return  id + " - " + title + " - " + description + " - " +  author + " - " + Arrays.toString(catagory) + " - " + publishing_year + " - "     + publishing_company;
    }
}
