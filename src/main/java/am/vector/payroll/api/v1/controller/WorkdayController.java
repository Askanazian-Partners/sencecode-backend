package am.vector.payroll.api.v1.controller;

import am.vector.payroll.api.v1.service.PersonService;
import am.vector.payroll.api.v1.service.WorkdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/workday",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WorkdayController extends APIController {

    private WorkdayService workdayService;

    @Autowired
    public WorkdayController(WorkdayService workdayService){
        this.workdayService = workdayService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/{START}/{END}")
    public String findAll(@PathVariable String START, @PathVariable String END){
        return gson.toJson(workdayService.getDateRange(LocalDate.parse(START), LocalDate.parse(END)));
    }
}
