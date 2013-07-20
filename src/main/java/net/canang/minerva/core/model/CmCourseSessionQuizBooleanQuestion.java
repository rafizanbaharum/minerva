package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseSessionQuizBooleanQuestion extends CmCourseSessionQuizQuestion {

    String getAnswerTrue();

    void setAnswerTrue(String answerTrue);

    String getAnswerFalse();

    void setAnswerFalse(String answerFalse);

}
