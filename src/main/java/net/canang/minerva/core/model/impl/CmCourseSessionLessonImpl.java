package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public class CmCourseSessionLessonImpl implements CmCourseSessionLesson {

    private Long id;
    private String name;
    private String title;
    private String description;
    private String keywords;
    private Integer order;
    private CmDifficulty difficulty;
    private CmInteractivityType interactivityType;
    private CmInteractivityLevel interactivityLevel;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
