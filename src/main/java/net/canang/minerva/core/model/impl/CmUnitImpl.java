package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmDepartment;
import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmUnit;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_UNIT")
@Entity(name = "CmUnit")
public class CmUnitImpl implements CmUnit {

    private Long id;
    private String code;
    private String alias;
    private String description;

    private CmDepartment department;
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

    public CmDepartment getDepartment() {
        return department;
    }

    public void setDepartment(CmDepartment department) {
        this.department = department;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
