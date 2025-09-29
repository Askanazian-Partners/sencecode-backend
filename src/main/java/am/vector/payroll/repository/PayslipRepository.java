package am.vector.payroll.repository;

import am.vector.payroll.entity.Payslip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "payslip", path = "payslip")
public interface PayslipRepository extends CrudRepository<Payslip, String> {
}
