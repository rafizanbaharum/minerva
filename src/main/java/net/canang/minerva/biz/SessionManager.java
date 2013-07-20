package net.canang.minerva.biz;

import net.canang.minerva.core.model.CmCourse;
import net.canang.minerva.core.model.CmSession;

/**
 * @author rafizan.baharum
 * @since 7/20/13
 */
public interface SessionManager {

    public void serializeToCourseSession(CmSession session, CmCourse course);

}
