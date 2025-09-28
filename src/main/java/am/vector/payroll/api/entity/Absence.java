package am.vector.payroll.api.entity;

import am.vector.payroll.constatns.LeaveType;
import am.vector.payroll.constatns.RecordState;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Absence extends UUIDEntity {

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;
    private int amount;
    private String ssn;
    private String period;
    private LocalDate startDate;
    private LocalDate endDate;

    public Absence() {
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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
}
