package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseQuizSection extends CmMetaObject {

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    CmCourseQuiz getQuiz();

    void setQuiz(CmCourseQuiz quiz);

    List<CmCourseQuestion> getQuestions();

    void setQuestions(List<CmCourseQuestion> questions);
}
