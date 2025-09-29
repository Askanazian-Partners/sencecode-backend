package am.vector.payroll.config;

import am.vector.payroll.entity.AppEntity;
import am.vector.payroll.entity.UUIDEntity;
import am.vector.payroll.constatns.RecordState;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BeforeCreateEventListener extends AbstractRepositoryEventListener {

    @Override
    public void onBeforeCreate(Object object) {
        if(object instanceof AppEntity) {
            AppEntity entity = (AppEntity) object;
            entity.setState(RecordState.CURRENT);
        }
        if(object instanceof UUIDEntity){
            UUIDEntity uuidEntity = (UUIDEntity) object;
            byte[] bytes = uuidEntity.getTin().getBytes();
            String tinUUID = UUID.nameUUIDFromBytes(bytes).toString().substring(0,8);
            String randomUuid = UUID.randomUUID().toString().substring(8);
            String uuid = tinUUID + randomUuid.replace("-","");
            uuidEntity.setUuid(uuid);
        }
    }
}