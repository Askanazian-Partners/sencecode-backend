package am.vector.payroll.api.v1.controller;

import am.vector.payroll.api.v1.service.PersonService;
import am.vector.payroll.api.v1.service.WorkdayService;
import am.vector.payroll.entity.Workday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        LocalDate start = LocalDate.parse(START);
        LocalDate end = LocalDate.parse(END);
        return gson.toJson(workdayService.getDateRange(start, end));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{DAY}")
    public String getDay(@PathVariable String DAY){
        return gson.toJson(workdayService.getWorkday(LocalDate.parse(DAY)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public String updateDay(@RequestBody String json){
        Workday object = gson.fromJson(json, Workday.class);
        return gson.toJson(workdayService.updateWorkday(object));
    }
}
