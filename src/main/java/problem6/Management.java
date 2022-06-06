package problem6;

import problem2.CongNhan;

import java.util.*;

public class Management {
    List<Person> managementList = new ArrayList<>();

    public void start(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println(addPerson().toString());
        System.out.println("---------------------------------------------------");
        System.out.println("Please enter the name of the person you want to delete: ");
        String deleteName = keyboard.nextLine();
        deletePerson(deleteName);
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

    public List<Person> deletePerson(String fullname){
        for (Person person:managementList) {
            if ( person.getFullName().equalsIgnoreCase(fullname) ){
                managementList.remove(person);
                System.out.println("Remove Success!");;
            }else System.out.println("Person not found!");
        }
        return managementList;
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
        String tableFormat = "| %-11s | %-11s | %-9.1d  | %-9.1d  | %-9.1f  | %-8s |%n";

        System.out.format("+-------------+-------------+-------------+------------+-----------------+--------------+   %n");
        System.out.format("| Full Name   | Address     | Score 1     | Score 2    | Average Score   | Grade        |  %n");
        System.out.format("+-------------+-------------+-------------+------------+-----------------+--------------+   %n");

        for (int i = 0; i < listOfStudent.size(); i++) {
            System.out.format(tableFormat,
                    listOfStudent.get(i).getFullName(),
                    listOfStudent.get(i).getAddress(),
                    listOfStudent.get(i).getScore1(),
                    listOfStudent.get(i).getScore2(),
                    listOfStudent.get(i).getAverageScore(),
                    listOfStudent.get(i).toGrade());
        }
        System.out.format("+-------------+-------------+-------------+------------+-----------------+--------------+   %n");

        List<Employee> listOfEmployee = new ArrayList<>();
        for (Person person:managementList
        ) {
            if ( person instanceof Employee ){
                listOfEmployee.add((Employee) person);
            }
        }
        String tableFormatE = "| %-11s | %-11s | %-11f | %-11f  | %-12.1f | %n";

        System.out.format("+---------------+---------------+-------------+-----------------+------------+  %n");
        System.out.format("| Full Name     | Address       | Pay Rate    | Working Hours   | Salary     | %n");
        System.out.format("+---------------+---------------+-------------+-----------------+------------+  %n");

        for (int i = 0; i < listOfEmployee.size(); i++) {
            System.out.format(tableFormatE,
                    listOfEmployee.get(i).getFullName(),
                    listOfEmployee.get(i).getAddress(),
                    listOfEmployee.get(i).getPayRate(),
                    listOfEmployee.get(i).getWorkingHours(),
                    listOfEmployee.get(i).getSalary());
        }
        System.out.format("+-------------+-------------+-------------+-----------------+------------+  %n");

        List<Customer> listOfCustomer = new ArrayList<>();
        for (Person person:managementList
        ) {
            if ( person instanceof Customer ){
                listOfCustomer.add((Customer) person);
            }
        }
        String tableFormatC = "| %-11s | %-11s | %-15s | %-12f  |%n";

        System.out.format("+-----------------+---------------+----------------+-----------+ %n");
        System.out.format("| Full Name       | Address       | Company Name   | Invoice   | %n");
        System.out.format("+-----------------+---------------+----------------+-----------+ %n");

        for (int i = 0; i < listOfEmployee.size(); i++) {
            System.out.format(tableFormatC,
                    listOfCustomer.get(i).getFullName(),
                    listOfCustomer.get(i).getAddress(),
                    listOfCustomer.get(i).getCompanyName(),
                    listOfCustomer.get(i).getInvoice());
        }
        System.out.format("+-------------+-------------+----------------+-----------+ %n");
    }
}
