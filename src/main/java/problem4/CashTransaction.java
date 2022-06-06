package problem4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CashTransaction extends Transaction{
    private CashType cashType;
    private double exchangeRate;
    private double toMoney;

    public CashTransaction(String id, LocalDate date, double price, int amount, CashType cashType, double exchangeRate) {
        super(id, date, price, amount);
        this.cashType = cashType;
        this.exchangeRate = exchangeRate;
    }

    @Override
    public double getMoney(){
        if ( cashType == CashType.EURO || cashType == CashType.USD ){
            return getAmount()*getPrice()*getExchangeRate();
        }else return getAmount()*getPrice();
    }
}
