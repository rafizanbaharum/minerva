package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_CORS_SESN_MODL")
@Entity(name = "CmCourseSessionModule")
public class CmCourseSessionModuleImpl implements CmCourseSessionModule {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_SESN_MODL")
    @SequenceGenerator(name = "SEQ_CM_CORS_SESN_MODL", sequenceName = "SEQ_CM_CORS_SESN_MODL", allocationSize = 1)
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

    @OneToOne(targetEntity = CmCourseSessionImpl.class)
    @JoinColumn(name = "COURSE_ID")
    private CmCourseSession course;

    @OneToMany(targetEntity = CmCourseSessionLessonImpl.class, mappedBy = "module")
    private List<CmCourseSessionLesson> lessons;

    @OneToMany(targetEntity = CmCourseSessionAssessmentImpl.class, mappedBy = "module")
    private List<CmCourseSessionAssessment> assessments;

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

    public CmCourseSession getCourse() {
        return course;
    }

    public void setCourse(CmCourseSession course) {
        this.course = course;
    }

    public List<CmCourseSessionLesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<CmCourseSessionLesson> lessons) {
        this.lessons = lessons;
    }

    public List<CmCourseSessionAssessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<CmCourseSessionAssessment> assessments) {
        this.assessments = assessments;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
