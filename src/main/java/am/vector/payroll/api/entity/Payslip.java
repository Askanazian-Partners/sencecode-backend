package am.vector.payroll.api.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Payslip extends UUIDEntity {

    private String period;
    private int wage;
    private int overtime;
    private int bonus;
    private int ssp;
    private int it;
    private int army;
    private boolean hasUpdate;
    @ManyToOne
    private Person person;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getSsp() {
        return ssp;
    }

    public void setSsp(int ssp) {
        this.ssp = ssp;
    }

    public int getIt() {
        return it;
    }

    public void setIt(int it) {
        this.it = it;
    }

    public int getArmy() {
        return army;
    }

    public void setArmy(int army) {
        this.army = army;
    }

    public boolean isHasUpdate() {
        return hasUpdate;
    }

    public void setHasUpdate(boolean hasUpdate) {
        this.hasUpdate = hasUpdate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Payslip() {
    }

}
