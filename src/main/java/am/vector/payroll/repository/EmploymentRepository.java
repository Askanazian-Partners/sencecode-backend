package am.vector.payroll.repository;

import am.vector.payroll.entity.Employment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employment", path = "employment")
public interface EmploymentRepository extends CrudRepository<Employment, String> {
}
