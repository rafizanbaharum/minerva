package net.canang.minerva.biz.impl;

import net.canang.minerva.biz.ManagerSupport;
import net.canang.minerva.biz.RegistrationManager;
import net.canang.minerva.biz.WorkflowManager;
import net.canang.minerva.core.model.CmCourseRegistration;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public class RegistrationManagerImpl extends ManagerSupport implements RegistrationManager {

    @Autowired
    private WorkflowManager workflowManager;

    @Override
    public void process(CmCourseRegistration registration) {
        publishProcessEvent(registration);
    }

    @Override
    public void serializeToEnrollment(CmCourseRegistration registration) {
    }
}
