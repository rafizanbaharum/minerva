package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmModule;
import net.canang.minerva.core.model.CmSubModule;

import javax.persistence.*;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_MODL")
@Entity(name = "CmModule")
public class CmModuleImpl implements CmModule {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_MODL")
    @SequenceGenerator(name = "SEQ_CM_MODL", sequenceName = "SEQ_CM_MODL", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "ALIAS")
    private String alias;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ORDR")
    private Integer order;

    @OneToMany(targetEntity = CmSubModuleImpl.class, mappedBy = "module", fetch = FetchType.EAGER)
    private Set<CmSubModule> subModules;

    @Embedded
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

    public Set<CmSubModule> getSubModules() {
        return subModules;
    }

    public void setSubModules(Set<CmSubModule> subModules) {
        this.subModules = subModules;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
