package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseModule extends CmMetaObject {

    String getName();

    String getTitle();

    String getDescription();

    String getKeywords();

    Integer getOrder();

    CmCourse getCourse();

    List<CmCourseLesson> getLessons();

    List<CmCourseQuiz> getQuizzes();
}
