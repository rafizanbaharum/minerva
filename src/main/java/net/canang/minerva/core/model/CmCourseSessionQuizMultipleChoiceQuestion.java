package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseSessionQuizMultipleChoiceQuestion extends CmCourseSessionQuizQuestion {

    String getAnswer1();

    void setAnswer1(String answer1);

    String getAnswer2();

    void setAnswer2(String answer2);

    String getAnswer3();

    void setAnswer3(String answer3);

    String getAnswer4();

    void setAnswer4(String answer4);
}
