package am.vector.payroll.repository;

import am.vector.payroll.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "company", path = "company")
public interface CompanyRepository extends CrudRepository<Company, String> {
}
