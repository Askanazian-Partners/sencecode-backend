package am.vector.payroll.repository;

import am.vector.payroll.entity.Timesheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "timesheet", path = "timesheet")
public interface TimesheetRepository extends CrudRepository<Timesheet, String> {
}
