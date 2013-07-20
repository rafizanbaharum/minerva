package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseSessionModule extends CmMetaObject {

    String getName();

    void setName(String name);

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    String getKeywords();

    void setKeywords(String keywords);

    Integer getOrder();

    void setOrder(Integer order);

    CmCourseSession getCourse();

    void setCourse(CmCourseSession course);

    List<CmCourseSessionLesson> getLessons();

    void setLessons(List<CmCourseSessionLesson> lessons);

    List<CmCourseSessionAssessment> getAssessments();

    void setAssessments(List<CmCourseSessionAssessment> assessments);
}
