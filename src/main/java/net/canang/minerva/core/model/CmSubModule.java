package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmSubModule extends CmMetaObject {

    String getCode();

    String getAlias();

    String getDescription();

    Integer getOrder();

}
