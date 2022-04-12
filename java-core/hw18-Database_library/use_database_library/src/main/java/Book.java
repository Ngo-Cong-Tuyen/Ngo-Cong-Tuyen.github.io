import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Book {
    private int id;
    private String title;
    private String img;
    private String description;
    private String author;
    private int publishing_year;
    private String publishing_company;
    private String category;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", publishing_year=" + publishing_year +
                ", publishing_company='" + publishing_company + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}