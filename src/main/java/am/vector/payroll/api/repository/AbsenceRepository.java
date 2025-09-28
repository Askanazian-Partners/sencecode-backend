package am.vector.payroll.api.repository;

import am.vector.payroll.api.entity.Absence;
import am.vector.payroll.api.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "absence", path = "absence")
public interface AbsenceRepository extends CrudRepository<Absence, String> {
}
