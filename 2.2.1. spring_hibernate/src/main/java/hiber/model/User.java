package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_car")
    private Car userCar;

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public User(String firstName, String lastName, String email, Car carsId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userCar = carsId;
    }


    public Car getCarsId() {
        return userCar;
    }

    public void setCarsId(Car carsId) {
        this.userCar = carsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User id - " + id +
                ", Имя - " + firstName +
                ", Фамилия - " + lastName +
                ", email - " + email +
                ", Авто: " + userCar;
    }
}
