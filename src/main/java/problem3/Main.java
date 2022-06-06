package problem3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListOfCourse listOfCourse = new ListOfCourse();
        Scanner keyboard = new Scanner(System.in);
        listOfCourse.addCourse();
        System.out.println("-------------------------------------");
        System.out.println(listOfCourse.toString());
        System.out.println("-------------------------------------");
        System.out.println("Please enter the name of the course you want to search: ");
        String searchCourseName = keyboard.nextLine();
        if ( listOfCourse.findCourse(searchCourseName) != null ){
            System.out.println(listOfCourse.findCourse(searchCourseName).toString());
        }else System.out.println("Course not found!");
        System.out.println("-------------------------------------");
        System.out.println("Please enter the phone number of the student that you " +
                "want to find the course that students had study: ");
        String searchPhoneNumber = keyboard.nextLine();
        if ( listOfCourse.findCourseThatStudentHadStudy(searchPhoneNumber) != null ){
            System.out.println(listOfCourse.findCourseThatStudentHadStudy(searchPhoneNumber).toString());
        }else System.out.println("Student not found!");
        System.out.println("-------------------------------------");
        if ( listOfCourse.findCourseThatDidNotEnd().size() == 0 ){
            System.out.println("All the course in the list had ended!");
        }else {
            System.out.println("Course that didn't ended: ");
            for (Course course: listOfCourse.findCourseThatDidNotEnd())
              {
                  System.out.println(course.toString());
            }
        }
        System.out.println("-------------------------------------");
        if ( listOfCourse.findCourseThatDidNotStart().size() == 0 ){
            System.out.println("All the course in the list had Started!");
        }else {
            System.out.println("Course that haven't start: ");
            for (Course course : listOfCourse.findCourseThatDidNotStart()) {
                System.out.println(course.toString());
            }
        }
        System.out.println("-------------------------------------");
    }
}
