package problem3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String lastName;
    private String firstName;
    private String address;
    private String phoneNumber;

}
