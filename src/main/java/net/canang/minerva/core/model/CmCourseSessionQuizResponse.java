package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseSessionQuizResponse extends CmMetaObject {

    String getText();

    void setText(String text);

    String getResponseCode();

    void setResponseCode(String responseCode);

    boolean isCorrect();

    void setCorrect(boolean correct);

}
