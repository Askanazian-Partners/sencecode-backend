package am.vector.payroll.api.repository;

import am.vector.payroll.api.entity.Company;
import am.vector.payroll.api.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "company", path = "company")
public interface CompanyRepository extends CrudRepository<Company, String> {
}
