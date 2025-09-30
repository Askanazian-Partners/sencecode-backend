package am.vector.payroll.config;

import am.vector.payroll.entity.AppEntity;
import am.vector.payroll.entity.UUIDEntity;
import am.vector.payroll.constatns.RecordState;
import am.vector.payroll.util.GeneralUtil;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BeforeCreateEventListener extends AbstractRepositoryEventListener {

    @Override
    public void onBeforeCreate(Object object) {
        GeneralUtil.createUUID(object);
    }
}