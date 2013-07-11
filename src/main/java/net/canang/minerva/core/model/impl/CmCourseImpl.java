package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmCourseImpl implements CmCourse {

    private Long id;
    private String name;
    private String description;
    private String keywords;
    private CmDifficulty difficulty;
    private CmInteractivityType interactivityType;
    private CmInteractivityLevel interactivityLevel;

    private CmDepartment department;
    private CmMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
