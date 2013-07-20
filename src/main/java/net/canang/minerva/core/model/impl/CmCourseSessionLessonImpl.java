package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_CORS_SESN_LSSN")
@Entity(name = "CmCourseSessionLesson")
public class CmCourseSessionLessonImpl implements CmCourseSessionLesson {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_SESN_LSSN")
    @SequenceGenerator(name = "SEQ_CM_CORS_SESN_LSSN", sequenceName = "SEQ_CM_CORS_SESN_LSSN", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "KEYWORDS")
    private String keywords;

    @Column(name = "ORDR")
    private Integer order;

    @Column(name = "SECTION_SHOWN")
    private boolean sectionShown;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "DIFFICULTY")
    private CmDifficulty difficulty;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "INTERACTIVITY_TYPE")
    private CmInteractivityType interactivityType;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "INTERACTIVITY_LEVEL")
    private CmInteractivityLevel interactivityLevel;

    @OneToOne(targetEntity = CmCourseSessionModuleImpl.class)
    @JoinColumn(name = "MODULE_ID")
    private CmCourseSessionModule module;

    @Embedded
    private CmMetadata metadata;

    public CmCourseSessionLessonImpl() {
        setSectionShown(true);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isSectionShown() {
        return sectionShown;
    }

    public void setSectionShown(boolean sectionShown) {
        this.sectionShown = sectionShown;
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

    public CmCourseSessionModule getModule() {
        return module;
    }

    public void setModule(CmCourseSessionModule module) {
        this.module = module;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
