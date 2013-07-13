package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmGradebook extends CmMetaObject {

    CmCourseSession getCourse();

    List<CmGrade> getGrades();

}
