package am.vector.payroll.repository;

import am.vector.payroll.entity.Absence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "absence", path = "absence")
public interface AbsenceRepository extends CrudRepository<Absence, String> {
}
