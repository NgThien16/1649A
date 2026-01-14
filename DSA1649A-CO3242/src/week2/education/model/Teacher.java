package week2.education.model;

public class Teacher extends User{
    private double salary;
    private String[] subject =new String[2];

    public Teacher(){}

    public Teacher(int id, String name, String telephone, String email, double salary, String subject1, String subject2) {
        super(id, name, telephone, email, "Teacher");
        this.salary = salary;
        this.subject[0] = subject1;
        this.subject[1] = subject2;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }
    @Override
    public String toString(){
        return "Teacher{" + super.toString() +","+ "salary =" + salary + ", Subject1 = " + subject[0] + ", Subject2 = " + subject[1] + "}";
    }
}
