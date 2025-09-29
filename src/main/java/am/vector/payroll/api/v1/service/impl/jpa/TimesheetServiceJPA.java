package am.vector.payroll.api.v1.service.impl.jpa;

import am.vector.payroll.api.v1.service.TimesheetService;
import am.vector.payroll.entity.Role;
import am.vector.payroll.entity.Timesheet;
import am.vector.payroll.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimesheetServiceJPA extends BaseServiceJPA implements TimesheetService {

    @Autowired
    private TimesheetRepository timesheetRepository;

    public Optional<Timesheet> findById(String SSN){
        return timesheetRepository.findById(SSN);
    }

    public Iterable<Timesheet> findAll(){
        return timesheetRepository.findAll();
    }

    public Timesheet save(Timesheet object){
        return timesheetRepository.save(object);
    }

    @Override
    public Iterable<Timesheet> saveAll(Iterable<Timesheet> objects) {
        return timesheetRepository.saveAll(objects);
    }

    @Override
    public boolean existsById(String id) {
        return timesheetRepository.existsById(id);
    }

    @Override
    public Iterable<Timesheet> findAllById(Iterable<String> id) {
        return timesheetRepository.findAllById(id);
    }

    @Override
    public long count() {
        return timesheetRepository.count();
    }

    @Override
    public void deleteById(String id) {
        timesheetRepository.deleteById(id);
    }

    @Override
    public void delete(Timesheet object) {
        timesheetRepository.delete(object);
    }

    @Override
    public void deleteAll(Iterable<Timesheet> objects) {
        timesheetRepository.deleteAll(objects);
    }

    @Override
    public void deleteAll() {
        timesheetRepository.deleteAll();
    }
}
