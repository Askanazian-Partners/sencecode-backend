package am.vector.payroll.entity;

import javax.persistence.*;

@Entity
public class Role extends UUIDEntity {

    private String code;
    private String name;
    private String description;
    private boolean laborRelation;
    private int eligibleDays;
    @ManyToOne
    private Department department;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLaborRelation() {
        return laborRelation;
    }

    public void setLaborRelation(boolean laborRelation) {
        this.laborRelation = laborRelation;
    }

    public int getEligibleDays() {
        return eligibleDays;
    }

    public void setEligibleDays(int eligibleDays) {
        this.eligibleDays = eligibleDays;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role() {
    }

}
