package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmDepartment;
import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmUnit;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_UNIT")
@Entity(name = "CmUnit")
public class CmUnitImpl implements CmUnit {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_UNIT")
    @SequenceGenerator(name = "SEQ_CM_UNIT", sequenceName = "SEQ_CM_UNIT", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "ALIAS")
    private String alias;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne(targetEntity = CmDepartmentImpl.class)
    @JoinColumn(name = "DEPARTMENT_ID")
    private CmDepartment department;

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
