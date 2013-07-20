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

    Integer getOrder();

    void setOrder(Integer order);


    CmCourseQuiz getQuiz();

    void setQuiz(CmCourseQuiz quiz);

    List<CmCourseQuizQuestion> getQuestions();

    void setQuestions(List<CmCourseQuizQuestion> questions);
}
