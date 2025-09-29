package am.vector.payroll.entity;

import am.vector.payroll.constatns.RecordState;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class AppEntity {

    @Enumerated(EnumType.STRING)
    private RecordState state;
    private String tin;
    private String recorderUUID;
    @Transient
    private long recordedDate;

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getRecorderUUID() {
        return recorderUUID;
    }

    public void setRecorderUUID(String recorderUUID) {
        this.recorderUUID = recorderUUID;
    }

    public RecordState getState() {

        return state;
    }

    public void setState(RecordState state) {
        this.state = state;
    }
}
