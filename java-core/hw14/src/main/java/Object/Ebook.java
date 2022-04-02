package Object;

public class Ebook extends Book{
    protected String capacity;
    protected int total_downloads;

    public Ebook(int id, String title, String description, String author, String[] catagory, int publishing_year, String publishing_company, String capacity, int total_downloads) {
        super(id, title, description, author, catagory, publishing_year, publishing_company);
        this.capacity = capacity;
        this.total_downloads = total_downloads;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getTotal_downloads() {
        return total_downloads;
    }

    public void setTotal_downloads(int total_downloads) {
        this.total_downloads = total_downloads;
    }

    @Override
    public String toString() {
        return super.toString()+ " - "+ capacity +" - " + total_downloads;
    }
}
