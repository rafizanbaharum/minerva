package net.canang.minerva.biz;

import net.canang.minerva.core.model.CmCourseRegistration;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface RegistrationManager {

    void process(CmCourseRegistration registration);

    void serializeToEnrollment(CmCourseRegistration registration);
}
