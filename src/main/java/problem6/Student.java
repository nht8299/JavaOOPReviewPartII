package problem6;

import lombok.Data;

@Data
public class Student extends Person{
    private int score1;
    private int score2;

    public Student(String fullName, String address, int score1, int score2) {

        super(fullName, address);
        this.score1 = score1;
        this.score2 = score2;
    }

    public Student(int score1, int score2) {
        this.score1 = score1;
        this.score2 = score2;
    }

    public int getAverageScore(){
        return (score1+score2)/2;
    }
    public char toGrade(){
        if ( getAverageScore() >= 90 ){
            return 'A';
        }else if (getAverageScore() >= 80){
            return 'B';
        }else if ( getAverageScore() >= 70 ){
            return 'C';
        }else if ( getAverageScore() >= 60 ){
            return 'D';
        }else return 'F';
    }
    @Override
    public String toString(){
        return super.toString() +
                "Score 1: " + score1 +"\n"+
                "Score 2: " + score2 +"\n"+
                "Average Score: "+ getAverageScore() +"\n"+
                "Grade: "+ toGrade()+"\n";
    }
}
