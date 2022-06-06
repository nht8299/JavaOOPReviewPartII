package problem6;

import lombok.Data;

@Data
public class Customer extends Person{
    private String companyName;
    private double invoice;

    public Customer(String fullName, String address, String companyName, double invoice) {
        super(fullName, address);
        this.companyName = companyName;
        this.invoice = invoice;
    }

    public Customer(String companyName, double invoice) {
        this.companyName = companyName;
        this.invoice = invoice;
    }
    @Override
    public String toString(){
        return super.toString()+
                "Company Name: " + companyName+"\n"+
                "Invoice: "+invoice+"\n";
    }
}
