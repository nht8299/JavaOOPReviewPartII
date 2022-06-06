package problem4;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Main {
    static List<Transaction> transactionList = new ArrayList<>();
    public static void main(String[] args) {
        transactionList.add(new GoldTransaction("G001", LocalDate.of(2020,5,10),200000,20,"Gold"));
        transactionList.add(new GoldTransaction("G002", LocalDate.of(2020,5,10),500000,200,"Gold"));
        transactionList.add(new CashTransaction("C001", LocalDate.of(2022,6,6),10000,100,CashType.valueOf("VND"),0));
        transactionList.add(new CashTransaction("C002", LocalDate.of(2022,6,6),100000,100,CashType.valueOf("USD"),0.000043));
        transactionList.add(new CashTransaction("C003", LocalDate.of(2022,6,6),1000000000,100,CashType.valueOf("EURO"),0.000040));
        System.out.println("---------------------------------------");
        System.out.println(transactionList.toString());
        System.out.println("---------------------------------------");
        System.out.println("Total amount of gold transaction: "+totalAmountGoldTransaction());
        System.out.println("---------------------------------------");
        System.out.println("Total amount of cash transaction: "+totalAmountCashTransaction());
        System.out.println("---------------------------------------");
        System.out.printf("Average money of cash transaction: %.2f\n",averageMoneyOfCashTransaction());
        System.out.println("---------------------------------------");
        if ( getTransactionHavaPriceOverOneBillion().size() == 0 ){
            System.out.println("Did not have any transaction over one billion!");
        }else System.out.println(getTransactionHavaPriceOverOneBillion().toString());

    }
    public static int totalAmountGoldTransaction(){
        int totalAmount = 0;
        for (Transaction transaction:transactionList
             ) {
            if ( transaction instanceof GoldTransaction ){
                totalAmount += transaction.getAmount();
            }
        }
        return totalAmount;
    }
    public static int totalAmountCashTransaction(){
        int totalAmount = 0;
        for (Transaction transaction:transactionList
             ) {
            if ( transaction instanceof CashTransaction ){
                totalAmount += transaction.getAmount();
            }
        }
        return totalAmount;
    }
    public static double averageMoneyOfCashTransaction(){
        double totalMoney = 0;
        int count = 0;
        for (Transaction transaction:transactionList){
            if ( transaction instanceof CashTransaction ){
                totalMoney += transaction.getMoney();
                count++;
            }
        }
        return totalMoney/count;
    }
    public static List<Transaction> getTransactionHavaPriceOverOneBillion(){
        List<Transaction> getTransaction = new ArrayList<>();
        for (Transaction transaction: transactionList
             ) {
            if ( transaction.getPrice() >= 1000000000 ){
                getTransaction.add(transaction);
            }
        }
        return getTransaction;
    }

}
