package net.canang.minerva.core.model;

import java.util.List;

/**
 * NOTE: user CmCourseImpl as template
 *
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseSession extends CmMetaObject {

    CmSession getSession();

    CmCourse getCourse();

    List<CmCourseSessionModule> getModules();

}
