package am.vector.payroll.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Person extends AppEntity {
    @Id
    private String ssn;
    private String code;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String cell;
    private LocalDate birthday;

    public Person() {
    }

    public String getSsn() {
        return ssn;
    }

    public Person setSsn(String ssn) {
        this.ssn = ssn;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Person setCode(String code) {
        this.code = code;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Person setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCell() {
        return cell;
    }

    public Person setCell(String cell) {
        this.cell = cell;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Person setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }
}
