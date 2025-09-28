package am.vector.payroll.api.entity;

import am.vector.payroll.constatns.RecordState;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Person {
    @Id
    private String ssn;
    private String code;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String cell;
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private RecordState state;
    private String tin;
    private String recorderUUID;

    public Person() {
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public RecordState getState() {
        return state;
    }

    public void setState(RecordState state) {
        this.state = state;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getRecorderUUID() {
        return recorderUUID;
    }

    public void setRecorderUUID(String recorderUUID) {
        this.recorderUUID = recorderUUID;
    }
}
