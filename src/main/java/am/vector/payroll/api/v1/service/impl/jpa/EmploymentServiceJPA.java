package am.vector.payroll.api.v1.service.impl.jpa;

import am.vector.payroll.api.v1.service.EmploymentService;
import am.vector.payroll.entity.Employment;
import am.vector.payroll.repository.EmploymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmploymentServiceJPA extends BaseServiceJPA implements EmploymentService {

    @Autowired
    private EmploymentRepository employmentRepository;

    public Optional<Employment> findById(String SSN){
        return employmentRepository.findById(SSN);
    }

    public Iterable<Employment> findAll(){
        return employmentRepository.findAll();
    }

    public Employment save(Employment object){
        return employmentRepository.save(object);
    }

    @Override
    public Iterable<Employment> saveAll(Iterable<Employment> objects) {
        return employmentRepository.saveAll(objects);
    }

    @Override
    public boolean existsById(String id) {
        return employmentRepository.existsById(id);
    }

    @Override
    public Iterable<Employment> findAllById(Iterable<String> id) {
        return employmentRepository.findAllById(id);
    }

    @Override
    public long count() {
        return employmentRepository.count();
    }

    @Override
    public void deleteById(String id) {
        employmentRepository.deleteById(id);
    }

    @Override
    public void delete(Employment object) {
        employmentRepository.delete(object);
    }

    @Override
    public void deleteAll(Iterable<Employment> objects) {
        employmentRepository.deleteAll(objects);
    }

    @Override
    public void deleteAll() {
        employmentRepository.deleteAll();
    }
}
