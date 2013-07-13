package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmModule;
import net.canang.minerva.core.model.CmSubModule;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_SMDL")
@Entity(name = "CmSubModule")
public class CmSubModuleImpl implements CmSubModule {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_SMDL")
    @SequenceGenerator(name = "SEQ_CM_SMDL", sequenceName = "SEQ_CM_SMDL", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "ALIAS")
    private String alias;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ORDR")
    private Integer order;

    @OneToOne(targetEntity = CmModuleImpl.class)
    @JoinColumn(name = "MODULE_ID")
    private CmModule module;

    @Embedded
    private CmMetadata metadata = new CmMetadata();

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
