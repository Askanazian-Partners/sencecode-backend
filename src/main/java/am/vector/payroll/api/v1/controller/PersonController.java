package am.vector.payroll.api.v1.controller;

import am.vector.payroll.entity.Person;
import am.vector.payroll.api.v1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/person",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PersonController extends APIController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
       this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String findAll(){
        return gson.toJson(personService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{SSN}")
    public String findById(@PathVariable String SSN){
        return gson.toJson(personService.findById(SSN));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String add(@RequestBody String json){
        Person object = personService.save(gson.fromJson(json, Person.class));
        return gson.toJson(object);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/balk/")
    public String addBalk(@RequestBody String json){
        Person object = personService.save(gson.fromJson(json, Person.class));
        return gson.toJson(object);
    }
}
