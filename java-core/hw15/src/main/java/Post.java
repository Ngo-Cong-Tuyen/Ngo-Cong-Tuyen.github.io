import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Post {
    private int id;
    private String title, content, description, thumnail;
    private int id_category, id_author;
    private Date create_at;
    private String status;

    @Override
    public String toString() {
        return id + " - " + title+ " - " + content+ " - " +description+ " - " + create_at+ " - " + status;
    }
}
