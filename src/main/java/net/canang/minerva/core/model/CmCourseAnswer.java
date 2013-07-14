package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseAnswer extends CmShareable, CmMetaObject {

    String getText();

    void setText(String text);

    Integer getOrder();

    void setOrder(Integer order);

    boolean isCorrect();

    void setCorrect(boolean correct);

}
