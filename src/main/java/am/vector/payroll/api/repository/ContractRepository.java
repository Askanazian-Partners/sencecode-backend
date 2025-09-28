package am.vector.payroll.api.repository;

import am.vector.payroll.api.entity.Contract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "contract", path = "contract")
public interface ContractRepository extends CrudRepository<Contract, String> {
}
