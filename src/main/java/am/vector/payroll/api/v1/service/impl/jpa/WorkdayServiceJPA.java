package am.vector.payroll.api.v1.service.impl.jpa;

import am.vector.payroll.api.v1.service.WorkdayService;
import am.vector.payroll.entity.Workday;
import am.vector.payroll.repository.WorkdayRepository;
import am.vector.payroll.util.DayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS) //AspectJ can be used instead
public class WorkdayServiceJPA extends BaseServiceJPA implements WorkdayService{

    private final WorkdayRepository workdayRepository;
    private final WorkdayServiceJPA _workdayServiceJPA; //AspectJ can be used instead

    @Autowired
    public WorkdayServiceJPA(WorkdayRepository workdayRepository, WorkdayServiceJPA workdayServiceJPA) {
        this.workdayRepository = workdayRepository;
        this._workdayServiceJPA = workdayServiceJPA;

    }

    public List<Workday> getDateRange(LocalDate start, LocalDate end){
        List<Workday> days = new ArrayList<>();
        while (!start.equals(end)){
            Workday workday = _workdayServiceJPA.getWorkday(start);
            days.add(workday);
            start = start.plusDays(1);
        }
        return days;
    }

    @Cacheable(value= "workday", key = "#date")
    public Workday getWorkday(LocalDate date){
        try {
            Thread.sleep(100);
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
