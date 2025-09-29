package am.vector.payroll.api.v1.service.impl.jpa;

import am.vector.payroll.api.v1.service.ContractService;
import am.vector.payroll.entity.Contract;
import am.vector.payroll.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractServiceJPA extends BaseServiceJPA implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public Optional<Contract> findById(String SSN){
        return contractRepository.findById(SSN);
    }

    public Iterable<Contract> findAll(){
        return contractRepository.findAll();
    }

    public Contract save(Contract object){
        return contractRepository.save(object);
    }

    @Override
    public Iterable<Contract> saveAll(Iterable<Contract> objects) {
        return contractRepository.saveAll(objects);
    }

    @Override
    public boolean existsById(String id) {
        return contractRepository.existsById(id);
    }

    @Override
    public Iterable<Contract> findAllById(Iterable<String> id) {
        return contractRepository.findAllById(id);
    }

    @Override
    public long count() {
        return contractRepository.count();
    }

    @Override
    public void deleteById(String id) {
        contractRepository.deleteById(id);
    }

    @Override
    public void delete(Contract object) {
        contractRepository.delete(object);
    }

    @Override
    public void deleteAll(Iterable<Contract> objects) {
        contractRepository.deleteAll(objects);
    }

    @Override
    public void deleteAll() {
        contractRepository.deleteAll();
    }
}
