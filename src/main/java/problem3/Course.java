package problem3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private String courseName;
    private LocalDate startDate;
    private int StudyTime;
    private List<Student> listOfStudent = new ArrayList<>(20);
}



