package pojo;

import com.github.javafaker.Faker;

public class UserForm {

    private String id;
    private String FirstName;
    private String LastName;
    Faker faker = new Faker();

    public UserForm(String id, String firstName, String lastName) {
        this.id = id;
        this.FirstName = firstName;
        this.LastName = lastName;
    }

    public UserForm() {

    }

    public String getId() {
        return faker.idNumber().valid();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public void setFirstName(String firstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }
}