package problem4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoldTransaction extends Transaction{
    private String goldType;

    public GoldTransaction(String id, LocalDate date, double price, int amount, String goldType) {
        super(id, date, price, amount);
        this.goldType = goldType;
    }

    @Override
    public double getMoney(){
        return super.getAmount() * super.getPrice();
    }
}
