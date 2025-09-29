package am.vector.payroll.api.v1.controller;

import com.google.gson.Gson;
import org.apache.log4j.Logger;

public abstract class APIController {
    protected static Gson gson = new Gson();
    protected final Logger LOGGER = Logger.getLogger(APIController.class);
}
