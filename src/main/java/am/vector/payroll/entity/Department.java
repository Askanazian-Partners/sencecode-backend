package am.vector.payroll.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Department extends UUIDEntity {

    private String code;
    private String name;
    private String costCenter;
    @OneToOne
    private Person head;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public Person getHead() {
        return head;
    }

    public void setHead(Person head) {
        this.head = head;
    }

    public Department() {
    }

}
