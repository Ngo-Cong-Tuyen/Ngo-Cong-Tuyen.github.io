import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class E_book extends Book {
    protected String capacity;
    protected int total_downloads;

    @Override
    public String toString() {
        return super.toString() + " - " + capacity + " - " + total_downloads;
    }
}