package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseSessionAnswer extends CmMetaObject{

    String getText();

    void setText(String text);

    Integer getOrder();

    void setOrder(Integer order);

    boolean isCorrect();

    void setCorrect(boolean correct);

}
