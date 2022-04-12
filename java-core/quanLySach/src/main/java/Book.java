import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    protected int id;
    protected String title, description, author;
    protected String category;
    protected int publishing_year;
    protected String publishing_company;

    @Override
    public String toString() {
        return  id + " - " + title + " - " + description + " - " +  author + " - " + category + " - " + publishing_year + " - "     + publishing_company;
    }
}
