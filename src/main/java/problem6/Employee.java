package problem6;

import lombok.Data;

@Data
public class Employee extends Person {

    private double payRate;
    private int workingHours;

    public Employee(String fullName, String address, double payRate,int workingHours) {
        super(fullName, address);
        this.payRate = payRate;
        this.workingHours = workingHours;
    }

    public Employee(double payRate) {
        this.payRate = payRate;
    }

    public double getSalary(){
        return workingHours*payRate;
    }
    @Override
    public String toString(){
        return super.toString() +
                "Working hours: "+ workingHours+
                "Pay rate: "+ payRate+
                "Salary: "+getSalary();
    }
}
