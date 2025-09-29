package am.vector.payroll.api.v1.service.impl.jpa;

import am.vector.payroll.api.v1.service.RoleService;
import am.vector.payroll.entity.Payslip;
import am.vector.payroll.entity.Role;
import am.vector.payroll.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceJPA extends BaseServiceJPA implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Optional<Role> findById(String SSN){
        return roleRepository.findById(SSN);
    }

    public Iterable<Role> findAll(){
        return roleRepository.findAll();
    }

    public Role save(Role object){
        return roleRepository.save(object);
    }

    @Override
    public Iterable<Role> saveAll(Iterable<Role> objects) {
        return roleRepository.saveAll(objects);
    }

    @Override
    public boolean existsById(String id) {
        return roleRepository.existsById(id);
    }

    @Override
    public Iterable<Role> findAllById(Iterable<String> id) {
        return roleRepository.findAllById(id);
    }

    @Override
    public long count() {
        return roleRepository.count();
    }

    @Override
    public void deleteById(String id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void delete(Role object) {
        roleRepository.delete(object);
    }

    @Override
    public void deleteAll(Iterable<Role> objects) {
        roleRepository.deleteAll(objects);
    }

    @Override
    public void deleteAll() {
        roleRepository.deleteAll();
    }
}
