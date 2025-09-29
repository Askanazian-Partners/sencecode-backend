package am.vector.payroll.api.v1.service.impl.jpa;

import am.vector.payroll.api.v1.service.PayslipService;
import am.vector.payroll.entity.Payslip;
import am.vector.payroll.repository.PayslipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PayslipServiceJPA extends BaseServiceJPA implements PayslipService {

    @Autowired
    private PayslipRepository payslipRepository;

    public Optional<Payslip> findById(String SSN){
        return payslipRepository.findById(SSN);
    }

    public Iterable<Payslip> findAll(){
        return payslipRepository.findAll();
    }

    public Payslip save(Payslip object){
        return payslipRepository.save(object);
    }

    @Override
    public Iterable<Payslip> saveAll(Iterable<Payslip> objects) {
        return payslipRepository.saveAll(objects);
    }

    @Override
    public boolean existsById(String id) {
        return payslipRepository.existsById(id);
    }

    @Override
    public Iterable<Payslip> findAllById(Iterable<String> id) {
        return payslipRepository.findAllById(id);
    }

    @Override
    public long count() {
        return payslipRepository.count();
    }

    @Override
    public void deleteById(String id) {
        payslipRepository.deleteById(id);
    }

    @Override
    public void delete(Payslip object) {
        payslipRepository.delete(object);
    }

    @Override
    public void deleteAll(Iterable<Payslip> objects) {
        payslipRepository.deleteAll(objects);
    }

    @Override
    public void deleteAll() {
        payslipRepository.deleteAll();
    }
}
