import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

public class film {
    private int id;
    private String title,author;
    private int page_number;
    private int release_year;
    private String[] category;

    public film(int id, String title, String author, int page_number, int release_year, String[] category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.page_number = page_number;
        this.release_year = release_year;
        this.category = category;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return id+" - " +title+" - "+Arrays.toString(category)+" - "+ author+" - "+ page_number+" - "+ release_year;
    }
}
