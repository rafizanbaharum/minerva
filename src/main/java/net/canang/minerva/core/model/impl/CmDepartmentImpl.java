package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmDepartment;
import net.canang.minerva.core.model.CmFaculty;
import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmUnit;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_DEPT")
@Entity(name = "CmDepartment")
public class CmDepartmentImpl implements CmDepartment {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_DEPT")
    @SequenceGenerator(name = "SEQ_CM_DEPT", sequenceName = "SEQ_CM_DEPT", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "ALIAS")
    private String alias;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne(targetEntity = CmFacultyImpl.class)
    @JoinColumn(name = "FACULTY_ID")
    private CmFaculty faculty;

    @OneToMany(targetEntity = CmUnitImpl.class, mappedBy = "department")
    private List<CmUnit> units;

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
