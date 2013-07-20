package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseSessionQuizQuestion extends CmMetaObject {

    String getTitle();

    void setTitle(String title);

    String getBody();

    void setBody(String body);

    String getAnswerCode();

    void setAnswerCode(String answerCode);

    Integer getOrder();

    void setOrder(Integer order);

    CmQuestionType getQuestionType();

    CmCourseSessionQuizSection getSection();

    void setSection(CmCourseSessionQuizSection section);

}
