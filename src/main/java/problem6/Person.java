package problem6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {
    private String fullName;
    private String address;

    @Override
    public String toString(){
        return "Full name: "+fullName+"\n"+
                "Address: "+address+"\n";
    }
}
