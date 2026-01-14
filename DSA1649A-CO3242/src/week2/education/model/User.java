package week2.education.model;

public abstract class User {
    private int id;
    private String name;
    private String telephone;
    private String email;
    private String role;

    public User(){

    }
    public User(int id, String name, String telephone, String email, String role){
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;}
    @Override
    public String toString(){
        return "id = " + id +","+"name = " + name +"," + "telephone = " + telephone +"," + "email = " + email +"," + "role = " + role ;
    }
}
