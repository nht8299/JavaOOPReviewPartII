package problem6;

import java.util.*;

public class Management {
    List<Person> managementList = new ArrayList<>();

    public void start(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println(addPerson().toString());
//        Person person = new Student("Thinh Nguyen","34 Dinh Tien Hoang",80,90);
//        Person person1 = new Student("Trung Nguyen","34 Dinh Tien Hoang",40,50);
//        Person person2 = new Employee("Toan Nguyen","34 Dinh Tien Hoang",200,90);
//        Person person3 = new Employee("Tuan Nguyen","34 Dinh Tien Hoang",20,3000);
//        Person person4 = new Customer("Hung Nguyen","34 Dinh Tien Hoang","Axon",900000);
//        managementList.add(person);
//        managementList.add(person1);
//        managementList.add(person2);
//        managementList.add(person3);
//        managementList.add(person4);
        System.out.println(managementList.toString());
        System.out.println("---------------------------------------------------");
        System.out.println("Please enter the name of the person you want to delete: ");
        int beforeDelete = managementList.size();
        String deleteName = keyboard.nextLine();
        deletePerson(deleteName);
        if (managementList.size() < beforeDelete){
            System.out.println("Delete success!");
        }else System.out.println("Person not found!");
        System.out.println("---------------------------------------------------");
        System.out.println("List of Person sort by full name : "+sortByFullName());
        printTable();
    }

    public List<Person> addPerson(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter number of Student: ");
        int numberStudent = keyboard.nextInt();
        for(int i = 1; i <= numberStudent;i++){
            managementList.add(createStudent(i));
        }
        System.out.println("Please enter number of Employee: ");
        int numberEmployee = keyboard.nextInt();
        for(int i = 1; i <= numberEmployee;i++){
            managementList.add(createEmployee(i));
        }
        System.out.println("Please enter number of Customer: ");
        int numberCustomer = keyboard.nextInt();
        for(int i = 1; i <= numberCustomer;i++){
            managementList.add(createCustomer(i));
        }
        return managementList;
    }

    public Student createStudent( int number){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter student "+number+" full name: ");
        String newStudentName = keyboard.nextLine();
        System.out.println("Please enter student "+number+" address: ");
        String newStudentAddress = keyboard.nextLine();
        System.out.println("Please enter student score 1: ");
        int newStudentScore1 = keyboard.nextInt();
        System.out.println("Please enter student score 2: ");
        int newStudentScore2 = keyboard.nextInt();
        return new Student(newStudentName,newStudentAddress,newStudentScore1,newStudentScore2);
    }

    public Employee createEmployee( int number){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter employee "+number+" full name: ");
        String newEmployeeName = keyboard.nextLine();
        System.out.println("Please enter employee "+number+" address: ");
        String newEmployeeAddress = keyboard.nextLine();
        System.out.println("Please enter the employee pay rate: ");
        double newEmployeePayRate = keyboard.nextDouble();
        System.out.println("Please enter the employee working hours: ");
        int newEmployeeWorkingHours = keyboard.nextInt();
        return new Employee(newEmployeeName,newEmployeeAddress,newEmployeePayRate,newEmployeeWorkingHours);
    }

    public Customer createCustomer(int number){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter customer "+number+" full name: ");
        String newCustomerName = keyboard.nextLine();
        System.out.println("Please enter customer "+number+" address: ");
        String newCustomerAddress = keyboard.nextLine();
        System.out.println("Please enter the customer company name : ");
        String newCustomerCompanyName = keyboard.nextLine();
        System.out.println("Please enter the customer invoice amount: ");
        double newCustomerInvoice = keyboard.nextDouble();
        return new Customer(newCustomerName,newCustomerAddress,newCustomerCompanyName,newCustomerInvoice);
    }

    public void deletePerson(String fullName){
       for(int i = 0; i < managementList.size();i++){
           if (managementList.get(i).getFullName().equalsIgnoreCase(fullName)){
               managementList.remove(managementList.get(i));
           }
       }
    }
    public List<Person>sortByFullName(){
            Collections.sort(managementList, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return o1.getFullName().compareTo(o2.getFullName());
                }
            });
            return managementList;
    }
    public void printTable() {
        List<Student> listOfStudent = new ArrayList<>();
        for (Person person:managementList
             ) {
            if ( person instanceof Student ){
                listOfStudent.add((Student) person);
            }
        }
        String tableFormat = "| %-10s | %-15s | %-9d  | %-9d  | %-12d  | %-8s |%n";

        System.out.format("+-------------+---------------------+------------+------------+---------------+----------+   %n");
        System.out.format("| Full Name   |        Address      | Score 1    | Score 2    | Average Score | Grade    |  %n");
        System.out.format("+-------------+---------------------+------------+------------+---------------+----------+   %n");

        for (int i = 0; i < listOfStudent.size(); i++) {
            System.out.format(tableFormat,
                    listOfStudent.get(i).getFullName(),
                    listOfStudent.get(i).getAddress(),
                    listOfStudent.get(i).getScore1(),
                    listOfStudent.get(i).getScore2(),
                    listOfStudent.get(i).getAverageScore(),
                    listOfStudent.get(i).toGrade());
        }
        System.out.format("+-------------+---------------------+------------+------------+---------------+----------+   %n");
        System.out.println("");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("");
        List<Employee> listOfEmployee = new ArrayList<>();
        for (Person person:managementList
        ) {
            if ( person instanceof Employee ){
                listOfEmployee.add((Employee) person);
            }
        }
        String tableFormatE = "| %-13s | %-18s | %-11.2f | %-13d  | %-10.1f | %n";

        System.out.format("+---------------+--------------------+-------------+----------------+------------+  %n");
        System.out.format("|   Full Name   |      Address       | Pay Rate    | Working Hours  | Salary     | %n");
        System.out.format("+---------------+--------------------+-------------+----------------+------------+  %n");

        for (int i = 0; i < listOfEmployee.size(); i++) {
            System.out.format(tableFormatE,
                    listOfEmployee.get(i).getFullName(),
                    listOfEmployee.get(i).getAddress(),
                    listOfEmployee.get(i).getPayRate(),
                    listOfEmployee.get(i).getWorkingHours(),
                    listOfEmployee.get(i).getSalary());
        }
        System.out.format("+---------------+--------------------+-------------+----------------+------------+  %n");
        System.out.println("");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("");
        List<Customer> listOfCustomer = new ArrayList<>();
        for (Person person:managementList
        ) {
            if ( person instanceof Customer ){
                listOfCustomer.add((Customer) person);
            }
        }
        String tableFormatC = "| %-15s | %-22s | %-15s | %-12.2f  |%n";

        System.out.format("+-----------------+------------------------+----------------+----------------+ %n");
        System.out.format("| Full Name       |          Address       | Company Name   |      Invoice   | %n");
        System.out.format(" %n");

        for (int i = 0; i < listOfCustomer.size(); i++) {
            System.out.format(tableFormatC,
                    listOfCustomer.get(i).getFullName(),
                    listOfCustomer.get(i).getAddress(),
                    listOfCustomer.get(i).getCompanyName(),
                    listOfCustomer.get(i).getInvoice());
        }
        System.out.format("+-----------------+------------------------+----------------+----------------+ %n");
    }
}
