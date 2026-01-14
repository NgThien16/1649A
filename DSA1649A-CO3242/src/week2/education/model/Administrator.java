package week2.education.model;

public class Administrator extends User{
    private double salary;
    private boolean isFullTime;
    private int workingHours;

    public Administrator(){

    }

    public Administrator(int id, String name, String telephone, String email, double salary, boolean isFullTime, int workingHours) {
        super(id, name, telephone, email, "Administrator");
        this.salary = salary;
        this.isFullTime = isFullTime;
        this.workingHours = workingHours;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return "Administrator: " + super.toString() +", Salary"+ salary+ ", FullTime" + isFullTime + ", WorkingHours" + workingHours;
    }
}
