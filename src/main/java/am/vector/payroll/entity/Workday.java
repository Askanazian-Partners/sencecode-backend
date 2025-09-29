package am.vector.payroll.entity;

import am.vector.payroll.constatns.DayShift;
import am.vector.payroll.constatns.Holiday;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.DayOfWeek;

@Entity
public class Workday {
    @Id
    private LocalDate day;

    @Enumerated(EnumType.STRING)
    private DayOfWeek weekDay;

    @Enumerated(EnumType.STRING)
    private DayShift shiftDay;

    @Enumerated(EnumType.STRING)
    private Holiday holiday;

    public Workday() {
    }

    public LocalDate getDay() {
        return day;
    }

    public Workday setDay(LocalDate day) {
        this.day = day;
        return this;
    }

    public DayOfWeek getWeekDay() {
        return weekDay;
    }

    public Workday setWeekDay(DayOfWeek weekDay) {
        this.weekDay = weekDay;
        return this;
    }

    public DayShift getShiftDay() {
        return shiftDay;
    }

    public Workday setShiftDay(DayShift shiftDay) {
        this.shiftDay = shiftDay;
        return this;
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public Workday setHoliday(Holiday holiday) {
        this.holiday = holiday;
        return this;
    }
}
