package am.vector.payroll.api.v1.service.impl.jpa;

import am.vector.payroll.api.v1.service.CompanyService;
import am.vector.payroll.entity.Company;
import am.vector.payroll.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceJPA extends BaseServiceJPA implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Optional<Company> findById(String SSN){
        return companyRepository.findById(SSN);
    }

    public Iterable<Company> findAll(){
        return companyRepository.findAll();
    }

    public Company save(Company object){
        return companyRepository.save(object);
    }

    @Override
    public Iterable<Company> saveAll(Iterable<Company> objects) {
        return companyRepository.saveAll(objects);
    }

    @Override
    public boolean existsById(String id) {
        return companyRepository.existsById(id);
    }

    @Override
    public Iterable<Company> findAllById(Iterable<String> id) {
        return companyRepository.findAllById(id);
    }

    @Override
    public long count() {
        return companyRepository.count();
    }

    @Override
    public void deleteById(String id) {
        companyRepository.deleteById(id);
    }

    @Override
    public void delete(Company object) {
        companyRepository.delete(object);
    }

    @Override
    public void deleteAll(Iterable<Company> objects) {
        companyRepository.deleteAll(objects);
    }

    @Override
    public void deleteAll() {
        companyRepository.deleteAll();
    }
}
