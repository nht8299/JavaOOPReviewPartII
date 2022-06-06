package problem4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Transaction {
    private String id;
    private LocalDate date;
    private double price;
    private int amount;

    public double getMoney(){
        return 0;
    }
}
