package net.canang.minerva.core.model;

import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmModule extends CmMetaObject{

    String getCode();

    void setCode(String code);

    String getAlias();

    void setAlias(String alias);

    String getDescription();

    void setDescription(String description);

    Integer getOrder();

    void setOrder(Integer order);

    Set<CmSubModule> getSubModules();

    void setSubModules(Set<CmSubModule> subModules);

}
