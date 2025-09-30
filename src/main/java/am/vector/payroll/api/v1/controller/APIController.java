package am.vector.payroll.api.v1.controller;

import am.vector.payroll.api.adapter.PersonTypeAdapter;
import am.vector.payroll.entity.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;

public abstract class APIController {
    GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Person.class, new PersonTypeAdapter());
    Gson gson = builder.create();

    protected final Logger LOGGER = Logger.getLogger(APIController.class);
}
