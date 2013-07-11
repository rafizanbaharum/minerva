package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmDepartment;
import net.canang.minerva.core.model.CmFaculty;
import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmUnit;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_DEPARTMENT")
@Entity(name = "CmDepartment")
public class CmDepartmentImpl implements CmDepartment {

    private Long id;
    private String code;
    private String alias;
    private String description;

    private CmFaculty faculty;
    private List<CmUnit> units;
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

    public CmFaculty getFaculty() {
        return faculty;
    }

    public void setFaculty(CmFaculty faculty) {
        this.faculty = faculty;
    }

    public List<CmUnit> getUnits() {
        return units;
    }

    public void setUnits(List<CmUnit> units) {
        this.units = units;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
