package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseAssessment;
import net.canang.minerva.core.model.CmCourseAssessmentType;
import net.canang.minerva.core.model.CmCourseModule;
import net.canang.minerva.core.model.CmMetadata;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_ASMT")
@Entity(name = "CmCourseAssessment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CmCourseAssessmentImpl implements CmCourseAssessment {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_ASMT")
    @SequenceGenerator(name = "SEQ_CM_CORS_ASMT", sequenceName = "SEQ_CM_CORS_ASMT", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "WEIGHT")
    private Integer weight;

    @Column(name = "SECTION_SHOWN")
    private boolean sectionShown;

    @Column(name = "ORDR")
    private Integer order;

    @Column(name = "ASSESSMENT_TYPE")
    private CmCourseAssessmentType assessmentType;

    @OneToOne(targetEntity = CmCourseModuleImpl.class)
    @JoinColumn(name = "MODULE_ID")
    private CmCourseModule module;

    @Embedded
    private CmMetadata metadata;

    public CmCourseAssessmentImpl() {
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


    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getWeight() {
        return weight;
    }

    public CmCourseAssessmentType getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(CmCourseAssessmentType assessmentType) {
        this.assessmentType = assessmentType;
    }

    public boolean isSectionShown() {
        return sectionShown;
    }

    public void setSectionShown(boolean sectionShown) {
        this.sectionShown = sectionShown;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public CmCourseModule getModule() {
        return module;
    }

    public void setModule(CmCourseModule module) {
        this.module = module;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
