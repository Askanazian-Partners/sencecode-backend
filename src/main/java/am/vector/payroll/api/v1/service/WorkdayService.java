package am.vector.payroll.api.v1.service;

import am.vector.payroll.entity.Workday;

import java.time.LocalDate;
import java.util.List;

public interface WorkdayService{
    List<Workday> getDateRange(LocalDate start, LocalDate end);
    Workday getWorkday(LocalDate date);
}
