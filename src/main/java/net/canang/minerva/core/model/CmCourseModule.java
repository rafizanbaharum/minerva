package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseModule extends CmMetaObject {

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

    CmCourse getCourse();

    void setCourse(CmCourse course);

    List<CmCourseLesson> getLessons();

    void setLessons(List<CmCourseLesson> lessons);

    List<CmCourseQuiz> getQuizzes();
}
