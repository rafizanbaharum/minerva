package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseAssessmentType;
import net.canang.minerva.core.model.CmCourseSessionAssessment;
import net.canang.minerva.core.model.CmCourseSessionModule;
import net.canang.minerva.core.model.CmMetadata;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_SESN_ASMT")
@Entity(name = "CmCourseSessionAssessment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CmCourseSessionAssessmentImpl implements CmCourseSessionAssessment {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_SESN_ASMT")
    @SequenceGenerator(name = "SEQ_CM_CORS_SESN_ASMT", sequenceName = "SEQ_CM_CORS_SESN_ASMT", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ORDR")
    private Integer order;

    @Column(name = "WEIGHT")
    private Integer weight;

    @Column(name = "SECTION_SHOWN")
    private boolean sectionShown;

    @Column(name = "ASSESSMENT_TYPE")
    private CmCourseAssessmentType assessmentType;

    @OneToOne(targetEntity = CmCourseSessionModuleImpl.class)
    @JoinColumn(name = "MODULE_ID")
    private CmCourseSessionModule module;

    @Embedded
    private CmMetadata metadata;

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

    public Integer getWeight() {
        return weight;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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
