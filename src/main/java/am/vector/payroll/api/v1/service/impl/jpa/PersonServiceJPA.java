package am.vector.payroll.api.v1.service.impl.jpa;

import am.vector.payroll.entity.Person;
import am.vector.payroll.repository.PersonRepository;
import am.vector.payroll.api.v1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceJPA extends BaseServiceJPA implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Cacheable(value= "person", key = "#SSN")
    public Optional<Person> findById(String SSN){
        return personRepository.findById(SSN);
    }

    public Iterable<Person> findAll(){
        return personRepository.findAll();
    }

    public Person save(Person object){
        return personRepository.save(object);
    }

    @Override
    public Iterable<Person> saveAll(Iterable<Person> objects) {
        return personRepository.saveAll(objects);
    }

    @Override
    public boolean existsById(String id) {
        return personRepository.existsById(id);
    }

    @Override
    public Iterable<Person> findAllById(Iterable<String> id) {
        return personRepository.findAllById(id);
    }

    @Override
    public long count() {
        return personRepository.count();
    }

    @Override
    public void deleteById(String id) {
        personRepository.deleteById(id);
    }

    @Override
    public void delete(Person object) {
        personRepository.delete(object);
    }

    @Override
    public void deleteAll(Iterable<Person> objects) {
        personRepository.deleteAll(objects);
    }

    @Override
    public void deleteAll() {
        personRepository.deleteAll();
    }
}
