package net.canang.minerva.biz;

import net.canang.minerva.core.model.CmCourseEnrollment;
import net.canang.minerva.core.model.CmCourseSession;
import net.canang.minerva.core.model.CmSession;
import net.canang.minerva.core.model.CmStudent;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface EnrollmentFinder {

    List<CmCourseEnrollment> findEnrollments(CmCourseSession course);

    List<CmCourseEnrollment> findEnrollments(CmStudent student, CmSession session);

}
