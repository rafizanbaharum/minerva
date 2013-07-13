package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmDepartment;
import net.canang.minerva.core.model.CmFaculty;
import net.canang.minerva.core.model.CmMetadata;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
@Table(name = "CM_FCTY")
@Entity(name = "CmFaculty")
public class CmFacultyImpl implements CmFaculty {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_FCTY")
    @SequenceGenerator(name = "SEQ_CM_FCTY", sequenceName = "SEQ_CM_FCTY", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "ALIAS")
    private String alias;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(targetEntity = CmDepartmentImpl.class, mappedBy = "faculty")
    private List<CmDepartment> departments;

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

    public List<CmDepartment> getDepartments() {
        return departments;
    }

    public void setDepartments(List<CmDepartment> departments) {
        this.departments = departments;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
