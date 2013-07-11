package net.canang.minerva.core.model;

import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmModule extends CmMetaObject{

    String getCode();

    String getAlias();

    String getDescription();

    Integer getOrder();

    Set<CmSubModule> getSubModules();

}
