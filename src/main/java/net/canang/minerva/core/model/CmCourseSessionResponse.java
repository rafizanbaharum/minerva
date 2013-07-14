package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseSessionResponse extends CmShareable, CmMetaObject {

    String getText();

    void setText(String text);

    CmCourseSessionAnswer getAnswer();

    void setAnswer(CmCourseSessionAnswer asnwer);

    boolean isCorrect();

    void setCorrect(boolean correct);

}
