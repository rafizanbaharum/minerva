package net.canang.minerva.biz;

import net.canang.minerva.biz.event.AccessEvent;
import net.canang.minerva.biz.event.EmailEvent;
import net.canang.minerva.biz.event.ProcessEvent;
import net.canang.minerva.biz.integration.CmPermission;
import net.canang.minerva.core.model.CmFlowObject;
import net.canang.minerva.core.model.CmMetaObject;
import net.canang.minerva.core.model.CmPrincipal;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public class ManagerSupport implements ApplicationContextAware {

    @Autowired
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.context = ctx;
    }

    public void publishAccessEvent(CmMetaObject source, CmPrincipal principal, CmPermission permission) {
        AccessEvent accessEvent = new AccessEvent(source, principal, permission);
        context.publishEvent(accessEvent);
    }

    public void publishProcessEvent(CmFlowObject flowObject) {
        ProcessEvent processEvent = new ProcessEvent(flowObject);
        context.publishEvent(processEvent);
    }

    public void publishEmailEvent(String from, String to, String subject, String body) {
        EmailEvent event = new EmailEvent(from, to, subject, body);
        context.publishEvent(event);
    }
}
