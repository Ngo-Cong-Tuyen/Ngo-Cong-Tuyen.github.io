import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.text.SimpleDateFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TransitionHistory {
    private int id;
    private int id_user;
    private String content;
    private Date date_transition;
    private String account;
    private int money;

    SimpleDateFormat simpleDate = new SimpleDateFormat("MM-dd-yyyy");
    @Override
    public String toString() {
        return id_user + " - " + simpleDate.format(date_transition) + " - " + content + " - " + account + " - " + money;
    }
}
