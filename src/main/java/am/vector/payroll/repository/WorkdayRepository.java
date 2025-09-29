package am.vector.payroll.repository;

import am.vector.payroll.entity.Workday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;

@RepositoryRestResource(collectionResourceRel = "workday", path = "workday")
public interface WorkdayRepository extends CrudRepository<Workday, LocalDate> {
}
