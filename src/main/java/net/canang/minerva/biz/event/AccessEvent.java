package net.canang.minerva.biz.event;

import net.canang.minerva.biz.integration.CmPermission;
import net.canang.minerva.core.model.CmMetaObject;
import net.canang.minerva.core.model.CmPrincipal;
import org.springframework.context.ApplicationEvent;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public class AccessEvent extends ApplicationEvent {

    private CmMetaObject object;
    private CmPrincipal principal;
    private CmPermission permission;

    public AccessEvent(CmMetaObject object, CmPrincipal principal, CmPermission permission) {
        super(object);
        this.object = object;
        this.principal = principal;
        this.permission = permission;
    }
}
