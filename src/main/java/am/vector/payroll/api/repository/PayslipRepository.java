package am.vector.payroll.api.repository;

import am.vector.payroll.api.entity.Payslip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "payslip", path = "payslip")
public interface PayslipRepository extends CrudRepository<Payslip, String> {
}
