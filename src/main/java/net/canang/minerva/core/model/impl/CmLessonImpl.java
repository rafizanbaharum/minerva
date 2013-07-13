package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_LSSN")
@Entity(name = "CmLesson")
public class CmLessonImpl implements CmLesson {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_LSSN")
    @SequenceGenerator(name = "SEQ_CM_LSSN", sequenceName = "SEQ_CM_LSSN", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "KEYWORDS")
    private String keywords;

    @Column(name = "ORDR")
    private Integer order;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "DIFFICULTY")
    private CmDifficulty difficulty;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "INTERACTIVITY_TYPE")
    private CmInteractivityType interactivityType;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "INTERACTIVITY_LEVEL")
    private CmInteractivityLevel interactivityLevel;

    @Embedded
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
