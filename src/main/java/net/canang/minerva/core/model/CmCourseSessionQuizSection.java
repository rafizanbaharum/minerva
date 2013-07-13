package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseSessionQuizSection extends CmMetaObject{

    String getTitle();

    String getDescription();

    CmCourseSessionQuiz getQuiz();

    List<CmCourseSessionQuestion> getQuestions();

}
