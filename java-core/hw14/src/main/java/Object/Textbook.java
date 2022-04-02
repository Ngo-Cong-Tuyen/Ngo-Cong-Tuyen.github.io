package Object;

public class Textbook extends Book{
    protected int page_number, amount;

    public Textbook(int id, String title, String description, String author, String[] catagory, int publishing_year, String publishing_company, int page_number, int amount) {
        super(id, title, description, author, catagory, publishing_year, publishing_company);
        this.page_number = page_number;
        this.amount = amount;
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return super.toString()+ " - "+ page_number +" - " +amount;
    }
}
