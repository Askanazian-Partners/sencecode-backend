package am.vector.payroll.api.v1.service.impl.jpa;

import am.vector.payroll.api.v1.service.*;
import am.vector.payroll.entity.*;
import am.vector.payroll.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AbsenceServiceJPA extends BaseServiceJPA implements AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;

    public Optional<Absence> findById(String SSN){
        return absenceRepository.findById(SSN);
    }

    public Iterable<Absence> findAll(){
        return absenceRepository.findAll();
    }

    public Absence save(Absence object){
        return absenceRepository.save(object);
    }

    @Override
    public Iterable<Absence> saveAll(Iterable<Absence> objects) {
        return absenceRepository.saveAll(objects);
    }

    @Override
    public boolean existsById(String id) {
        return absenceRepository.existsById(id);
    }

    @Override
    public Iterable<Absence> findAllById(Iterable<String> id) {
        return absenceRepository.findAllById(id);
    }

    @Override
    public long count() {
        return absenceRepository.count();
    }

    @Override
    public void deleteById(String id) {
        absenceRepository.deleteById(id);
    }

    @Override
    public void delete(Absence object) {
        absenceRepository.delete(object);
    }

    @Override
    public void deleteAll(Iterable<Absence> objects) {
        absenceRepository.deleteAll(objects);
    }

    @Override
    public void deleteAll() {
        absenceRepository.deleteAll();
    }
}
