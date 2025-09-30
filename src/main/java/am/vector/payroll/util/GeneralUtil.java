package am.vector.payroll.util;

import am.vector.payroll.constatns.RecordState;
import am.vector.payroll.entity.AppEntity;
import am.vector.payroll.entity.UUIDEntity;

import java.util.UUID;

public class GeneralUtil {
    public static void createUUID(Object object){
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
