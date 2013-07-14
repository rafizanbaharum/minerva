package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS")
@Entity(name = "CmCourse")
public class CmCourseImpl implements CmCourse {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS")
    @SequenceGenerator(name = "SEQ_CM_CORS", sequenceName = "SEQ_CM_CORS", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "KEYWORDS")
    private String keywords;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "DIFFICULTY")
    private CmDifficulty difficulty;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "INTERACTIVITY_TYPE")
    private CmInteractivityType interactivityType;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "INTERACTIVITY_LEVEL")
    private CmInteractivityLevel interactivityLevel;

    @OneToOne(targetEntity = CmDepartmentImpl.class)
    @JoinColumn(name = "DEPARTMENT_ID")
    private CmDepartment department;

    @OneToMany(targetEntity = CmCourseAssetImpl.class, mappedBy = "course")
    private List<CmCourseAsset> assets;

    @OneToMany(targetEntity = CmCourseModuleImpl.class, mappedBy = "course")
    private List<CmCourseModule> modules;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public CmDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(CmDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public CmInteractivityType getInteractivityType() {
        return interactivityType;
    }

    public void setInteractivityType(CmInteractivityType interactivityType) {
        this.interactivityType = interactivityType;
    }

    public CmInteractivityLevel getInteractivityLevel() {
        return interactivityLevel;
    }

    public void setInteractivityLevel(CmInteractivityLevel interactivityLevel) {
        this.interactivityLevel = interactivityLevel;
    }

    public CmDepartment getDepartment() {
        return department;
    }

    public void setDepartment(CmDepartment department) {
        this.department = department;
    }

    public List<CmCourseAsset> getAssets() {
        return assets;
    }

    public void setAssets(List<CmCourseAsset> assets) {
        this.assets = assets;
    }

    public List<CmCourseModule> getModules() {
        return modules;
    }

    public void setModules(List<CmCourseModule> modules) {
        this.modules = modules;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
