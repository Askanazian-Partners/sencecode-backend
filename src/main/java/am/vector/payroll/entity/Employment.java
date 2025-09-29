package am.vector.payroll.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Employment extends UUIDEntity {

    private LocalDate hireDate;
    private LocalDate terminationDate;
    private int vacationBalance;
    @ManyToOne
    private Person person;

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }

    public int getVacationBalance() {
        return vacationBalance;
    }

    public void setVacationBalance(int vacationBalance) {
        this.vacationBalance = vacationBalance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Employment() {
    }

}
