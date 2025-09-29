package am.vector.payroll.api.v1.service.impl.jpa;

import am.vector.payroll.api.v1.service.DepartmentService;
import am.vector.payroll.entity.Department;
import am.vector.payroll.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceJPA extends BaseServiceJPA implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Optional<Department> findById(String SSN){
        return departmentRepository.findById(SSN);
    }

    public Iterable<Department> findAll(){
        return departmentRepository.findAll();
    }

    public Department save(Department object){
        return departmentRepository.save(object);
    }

    @Override
    public Iterable<Department> saveAll(Iterable<Department> objects) {
        return departmentRepository.saveAll(objects);
    }

    @Override
    public boolean existsById(String id) {
        return departmentRepository.existsById(id);
    }

    @Override
    public Iterable<Department> findAllById(Iterable<String> id) {
        return departmentRepository.findAllById(id);
    }

    @Override
    public long count() {
        return departmentRepository.count();
    }

    @Override
    public void deleteById(String id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void delete(Department object) {
        departmentRepository.delete(object);
    }

    @Override
    public void deleteAll(Iterable<Department> objects) {
        departmentRepository.deleteAll(objects);
    }

    @Override
    public void deleteAll() {
        departmentRepository.deleteAll();
    }
}
