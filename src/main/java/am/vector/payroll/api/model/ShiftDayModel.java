package am.vector.payroll.api.model;

import java.time.LocalDate;

public class ShiftDayModel {
    private LocalDate date;
    private boolean isWorking;
    private String text;
    private String decree;
    private boolean reasonIsHoliday;

    public ShiftDayModel() {
    }

    public boolean isWorking() {
        return isWorking;
    }

    public ShiftDayModel setWorking(boolean working) {
        isWorking = working;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public ShiftDayModel setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public String getText() {
        return text;
    }

    public ShiftDayModel setText(String text) {
        this.text = text;
        return this;
    }

    public String getDecree() {
        return decree;
    }

    public ShiftDayModel setDecree(String decree) {
        this.decree = decree;
        return this;
    }

    public boolean isReasonIsHoliday() {
        return reasonIsHoliday;
    }

    public ShiftDayModel setReasonIsHoliday(boolean reasonIsHoliday) {
        this.reasonIsHoliday = reasonIsHoliday;
        return this;
    }
}
