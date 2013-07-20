package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseQuizQuestion extends CmShareable, CmMetaObject {

    String getTitle();

    void setTitle(String title);

    String getBody();

    void setBody(String body);

    String getAnswerCode();

    void setAnswerCode(String answerCode);

    Integer getOrder();

    void setOrder(Integer order);

    CmQuestionType getQuestionType();

    CmCourseQuizSection getSection();

    void setSection(CmCourseQuizSection section);
}
