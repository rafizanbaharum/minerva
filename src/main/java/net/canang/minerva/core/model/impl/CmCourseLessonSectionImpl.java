package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_LSSN_SCTN")
@Entity(name = "CmCourseLessonSection")
public class CmCourseLessonSectionImpl implements CmCourseLessonSection {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_LSSN_SCTN")
    @SequenceGenerator(name = "SEQ_CM_CORS_LSSN_SCTN", sequenceName = "SEQ_CM_CORS_LSSN_SCTN", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ORDR")
    private Integer order;

    @OneToOne(targetEntity = CmCourseLessonImpl.class)
    @JoinColumn(name = "LESSON_ID")
    private CmCourseLesson lesson;

    @OneToMany(targetEntity = CmCourseLessonContentImpl.class, mappedBy = "section")
    private List<CmCourseLessonContent> contents;

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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public CmCourseLesson getLesson() {
        return lesson;
    }

    public void setLesson(CmCourseLesson lesson) {
        this.lesson = lesson;
    }

    public List<CmCourseLessonContent> getContents() {
        return contents;
    }

    public void setContents(List<CmCourseLessonContent> contents) {
        this.contents = contents;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
