package problem3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOfCourse {
    List<Course> listOfCourse = new ArrayList<>();

    public void addCourse() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter number of course: ");
        int number = keyboard.nextInt();
        for (int i = 1; i <= number; i++) {
            listOfCourse.add(creatCourse(i));
        }
    }

    public Course creatCourse(int number) {
        Scanner keyboard = new Scanner(System.in);
        Course newCourse = new Course();
        System.out.println("Please enter the course " + number + " name : ");
        String newCourseName = keyboard.nextLine();
        newCourse.setCourseName(newCourseName);
        System.out.println("Please enter the course " + number + " start date: (YYYY-MM-DD)");
        LocalDate newCourseStartDate = LocalDate.parse(keyboard.nextLine());
        newCourse.setStartDate(newCourseStartDate);
        System.out.println("Please enter the study time of the course:(Month)  ");
        int newCourseStudyTime = keyboard.nextInt();
        newCourse.setStudyTime(newCourseStudyTime);
        System.out.println("Please enter the number of Student:(<20) ");
        int newCourseNumberOfStudent = keyboard.nextInt();
        while (newCourseNumberOfStudent > 20) {
            System.out.println("Invalid input!");
            System.out.println("Please enter the number of student smaller than 20!");
            newCourseNumberOfStudent = keyboard.nextInt();
        }
        List<Student> listStudentOfTheCourse = new ArrayList<>();
        for (int i = 1; i <= newCourseNumberOfStudent; i++) {
            listStudentOfTheCourse.add(createStudent(i));
        }
        newCourse.setListOfStudent(listStudentOfTheCourse);
        return newCourse;
    }

    public Student createStudent(int number) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the student " + number + " last name: ");
        String newStudentLastName = keyboard.nextLine();
        System.out.println("Please enter the student " + number + " first name: ");
        String newStudentFirstName = keyboard.nextLine();
        System.out.println("Please enter the student " + number + " address: ");
        String newStudentAddress = keyboard.nextLine();
        System.out.println("Please enter the student " + number + " phone number: ");
        String newStudentPhoneNumber = keyboard.nextLine();
        return new Student(newStudentLastName, newStudentFirstName, newStudentAddress, newStudentPhoneNumber);
    }

    public Course findCourse(String courseName) {
        Course findCourse = new Course();
        for (Course course : listOfCourse) {
            if ( course.getCourseName().toLowerCase().equals(courseName.toLowerCase()) ) {
                findCourse = course;
            }
        }
        return findCourse;
    }

    public Course findCourseThatStudentHadStudy(String phoneNumber) {
        Course findCourse = new Course();
        for (Course course : listOfCourse) {
            for (Student student : course.getListOfStudent()) {
                if ( student.getPhoneNumber().equals(phoneNumber) ) {
                    findCourse = course;
                }
            }
        }
        return findCourse;
    }

    public List<Course> findCourseThatDidNotEnd() {
        List<Course> listOfFindCourse = new ArrayList<>();
        for (Course course : listOfCourse
        ) {
            if ( LocalDate.now().isBefore(course.getStartDate().plusMonths(course.getStudyTime())) )
                listOfFindCourse.add(course);
        }
        return listOfFindCourse;
    }


    public List<Course> findCourseThatDidNotStart() {
        List<Course> listOfFindCourse = new ArrayList<>();
        for (Course course : listOfCourse) {
            if ( course.getStartDate().isAfter(LocalDate.now()) ) {
                listOfFindCourse.add(course);
            }
        }
        return listOfFindCourse;
    }
}
