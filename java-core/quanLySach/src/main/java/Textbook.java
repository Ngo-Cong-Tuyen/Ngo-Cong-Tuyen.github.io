import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Textbook extends Book{
    protected int page_number, amount;

    @Override
    public String toString() {
        return super.toString()+ " - " + page_number + " - " + amount;
    }
}
