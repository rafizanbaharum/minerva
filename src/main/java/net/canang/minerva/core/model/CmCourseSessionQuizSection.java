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

    Integer getOrder();

    void setOrder(Integer order);

    CmCourseSessionQuiz getQuiz();

    void setQuiz(CmCourseSessionQuiz quiz);

    List<CmCourseSessionQuizQuestion> getQuestions();

    void setQuestions(List<CmCourseSessionQuizQuestion> questions);

}
