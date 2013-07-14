package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseSessionQuizSection extends CmMetaObject{

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    CmCourseSessionQuiz getQuiz();

    void setQuiz(CmCourseSessionQuiz quiz);

    List<CmCourseSessionQuestion> getQuestions();

    void setQuestions(List<CmCourseSessionQuestion> questions);

}
