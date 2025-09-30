package am.vector.payroll.api.v1.controller;

import am.vector.payroll.api.v1.service.EmploymentService;
import am.vector.payroll.api.v1.service.PersonService;
import am.vector.payroll.config.BeforeCreateEventListener;
import am.vector.payroll.entity.Employment;
import am.vector.payroll.entity.Person;
import am.vector.payroll.util.GeneralUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/employment",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmploymentController extends APIController {

    private EmploymentService employmentService;
    private PersonService personService;

    public EmploymentController(EmploymentService employmentService, PersonService personService){
        this.employmentService = employmentService;
        this.personService = personService;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String add(@RequestBody String json){

        JsonObject employment = gson.fromJson(json, JsonObject.class);
        Person person = gson.fromJson(employment.get("person").getAsJsonObject(), Person.class);
        personService.save(person);
        Employment emp = gson.fromJson(json, Employment.class);
        GeneralUtil.createUUID(emp);
        Employment object = employmentService.save(emp);
        return gson.toJson(object);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String findAll(){
        Iterable<Employment> list = employmentService.findAll();
        Employment emp = list.iterator().next();
//        Person person = emp.getPerson();
//        String ssn = person.getSsn();
//        JsonObject obj = gson.toJsonTree(emp).getAsJsonObject();
        return gson.toJson(list);
    }
}
