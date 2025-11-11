package day2;

public class Pojo {

    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String[] courses;   // Array of courses

    // No-arg constructor (required for serialization)
    public Pojo() {}

    // Optional All-args constructor
    public Pojo(String id, String firstName, String lastName, String gender, String[] courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.courses = courses;
    }
    
    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String[] getCourses() { return courses; }
    public void setCourses(String[] courses) { this.courses = courses; }
    
}
