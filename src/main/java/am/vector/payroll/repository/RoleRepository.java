package am.vector.payroll.repository;

import am.vector.payroll.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "role", path = "role")
public interface RoleRepository extends CrudRepository<Role, String> {
}
