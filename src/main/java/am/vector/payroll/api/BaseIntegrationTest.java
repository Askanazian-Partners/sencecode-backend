package am.vector.payroll.api;

import am.vector.payroll.api.v1.service.*;
import am.vector.payroll.api.v1.service.BaseService;
import am.vector.payroll.util.Pair;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Stack;

import static org.junit.Assert.fail;

/**
 * Base class for all integration tests
 */
@Ignore
public class BaseIntegrationTest extends BaseTest {
    static protected Stack<Pair<String,BaseService>> autoDelete = new Stack<>();

    @Autowired
    private PersonService personService;

    protected static void doAutoDelete(){
        try {
            while (!autoDelete.empty()){
                Pair<String,BaseService> record = autoDelete.pop();
                BaseService service = record.getSecond();
                service.deleteById(record.getFirst());
            }
        } catch (Exception e){
            fail("Entity removal failed. Detail: "+e.getMessage());
        }
    }

}
