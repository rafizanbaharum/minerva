package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmModule;
import net.canang.minerva.core.model.CmSubModule;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmSubModuleImpl implements CmSubModule {

    private Long id;
    private String code;
    private String alias;
    private String description;
    private Integer order;
    private CmModule module;

    private CmMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public CmModule getModule() {
        return module;
    }

    public void setModule(CmModule module) {
        this.module = module;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
