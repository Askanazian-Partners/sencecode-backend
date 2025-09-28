package am.vector.payroll.entity;

import am.vector.payroll.constatns.RecordState;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_person")
public class Person {
    @Id
    private String ssn;
    private String code;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String email;
    private String cell;
    private LocalDate birthday;
    private String state;
    private String tin;
    private String recorder_uuid;

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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getRecorder_uuid() {
        return recorder_uuid;
    }

    public void setRecorder_uuid(String recorder_uuid) {
        this.recorder_uuid = recorder_uuid;
    }
}
