package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmAnswer extends CmShareable, CmMetaObject {

    String getText();

    Integer getOrder();

    boolean isCorrect();

}
