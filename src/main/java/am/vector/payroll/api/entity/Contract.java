package am.vector.payroll.api.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Contract extends UUIDEntity {

    private int salary;
    private LocalDate startDate;
    private LocalDate endDate;
    private int dailyHours;
    @ManyToOne
    private Person person;
    @ManyToOne
    private Role role;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getDailyHours() {
        return dailyHours;
    }

    public void setDailyHours(int dailyHours) {
        this.dailyHours = dailyHours;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Contract() {
    }

}
