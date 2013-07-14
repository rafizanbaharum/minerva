package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmGradebook extends CmMetaObject {

    CmCourseSession getCourse();

    void setCourse(CmCourseSession course);

    List<CmGrade> getGrades();

    void setGrades(List<CmGrade> grades);

}
