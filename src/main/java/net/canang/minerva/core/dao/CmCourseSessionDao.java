package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmCourseSession;
import net.canang.minerva.core.model.CmDepartment;
import net.canang.minerva.core.model.CmSession;
import net.canang.minerva.core.model.CmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseSessionDao {

    List<CmCourseSession> getCourses(CmSession session);

    List<CmCourseSession> getCourses(CmSession session, CmDepartment department);

    void save(CmCourseSession courseSession, CmUser user);

    void update(CmCourseSession courseSession, CmUser user);

    void remove(CmCourseSession courseSession, CmUser user);
}
