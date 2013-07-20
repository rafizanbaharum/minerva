package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_CORS_LSSN")
@Entity(name = "CmCourseLesson")
public class CmCourseLessonImpl implements CmCourseLesson {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_LSSN")
    @SequenceGenerator(name = "SEQ_CM_CORS_LSSN", sequenceName = "SEQ_CM_CORS_LSSN", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "KEYWORDS")
    private String keywords;

    @Column(name = "SECTION_SHOWN")
    private boolean sectionShown;

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

    @OneToOne(targetEntity = CmCourseModuleImpl.class)
    @JoinColumn(name = "MODULE_ID")
    private CmCourseModule module;

    @OneToMany(targetEntity = CmCourseLessonSectionImpl.class, mappedBy = "lesson")
    private List<CmCourseLessonSection> sections;

    @Embedded
    private CmMetadata metadata;


    public CmCourseLessonImpl() {
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

    public boolean isSectionShown() {
        return sectionShown;
    }

    public void setSectionShown(boolean sectionShown) {
        this.sectionShown = sectionShown;
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

    public CmCourseModule getModule() {
        return module;
    }

    public void setModule(CmCourseModule module) {
        this.module = module;
    }

    public List<CmCourseLessonSection> getSections() {
        return sections;
    }

    public void setSections(List<CmCourseLessonSection> sections) {
        this.sections = sections;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
