package net.canang.minerva.biz;

import net.canang.minerva.core.model.CmCourseEnrollment;
import net.canang.minerva.core.model.CmCourseRegistration;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface EnrollmentManager {

    void process(CmCourseRegistration registration);
}
