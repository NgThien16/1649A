package week2.education.model;

public class Student extends  User{
    private String[] subject = new String[3];

    public Student(){}

    public Student(int id, String name, String telephone, String email, String subject1, String subject2, String subject3) {
        super(id, name, telephone, email, "Student");
        this.subject[0] = subject1;
        this.subject[1] = subject2;
        this.subject[2] = subject3;
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{ " + super.toString() +", Subject 1: "+ subject[0] + ", Subject 2: "+ subject[1] + ", Subject 3: "+ subject[2] + " }";
    }
}
