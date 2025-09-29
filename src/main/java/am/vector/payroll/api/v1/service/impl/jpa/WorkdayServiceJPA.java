package am.vector.payroll.api.v1.service.impl.jpa;

import am.vector.payroll.api.v1.service.WorkdayService;
import am.vector.payroll.entity.Workday;
import am.vector.payroll.repository.WorkdayRepository;
import am.vector.payroll.util.DayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkdayServiceJPA extends BaseServiceJPA implements WorkdayService{

    private final WorkdayRepository workdayRepository;

    @Autowired
    public WorkdayServiceJPA(WorkdayRepository workdayRepository) {
        this.workdayRepository = workdayRepository;
    }

    public List<Workday> getDateRange(LocalDate start, LocalDate end){
        List<Workday> days = new ArrayList<>();
        while (!start.equals(end)){
            Workday workday = getWorkday(start);
            days.add(workday);
            start = start.plusDays(1);
        }
        return days;
    }

    @Cacheable(value= "workday", key = "#date")
    public Workday getWorkday(LocalDate date){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Workday workDay;
        Optional<Workday> day = workdayRepository.findById(date);
        if(day.isPresent()){
            workDay = day.get();
        } else {
            workDay = DayUtil.generateDay(date);
            workdayRepository.save(workDay);
        }
        return workDay;
    }


}
