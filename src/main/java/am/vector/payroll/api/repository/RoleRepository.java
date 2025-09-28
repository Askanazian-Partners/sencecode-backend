package am.vector.payroll.api.repository;

import am.vector.payroll.api.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "role", path = "role")
public interface RoleRepository extends CrudRepository<Role, String> {
}
