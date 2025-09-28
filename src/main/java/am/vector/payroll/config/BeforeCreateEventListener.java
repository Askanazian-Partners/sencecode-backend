package am.vector.payroll.config;

import am.vector.payroll.api.entity.UUIDEntity;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BeforeCreateEventListener extends AbstractRepositoryEventListener {

    @Override
    public void onBeforeCreate(Object entity) {
        if(entity instanceof UUIDEntity) {
            UUIDEntity uuidEntity = (UUIDEntity) entity;
            byte[] bytes = uuidEntity.getTin().getBytes();
            String tinUUID = UUID.nameUUIDFromBytes(bytes).toString().substring(0,8);
            String randomUuid = UUID.randomUUID().toString().substring(8);
            String uuid = tinUUID + randomUuid.replace("-","");
            uuidEntity.setUuid(uuid);
       }
    }
}