package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseSessionModule extends CmMetaObject {

    String getName();

    String getTitle();

    String getDescription();

    String getKeywords();

    Integer getOrder();

    CmCourseSession getCourse();

    List<CmCourseSessionLesson> getLessons();

    List<CmCourseSessionQuiz> getQuizzes();
}
