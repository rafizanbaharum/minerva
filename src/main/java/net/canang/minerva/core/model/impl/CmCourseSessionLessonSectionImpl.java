package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_SESN_LSSN_SCTN")
@Entity(name = "CmCourseSessionLessonSection")
public class CmCourseSessionLessonSectionImpl implements CmCourseSessionLessonSection {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_SESN_LSSN_SCTN")
    @SequenceGenerator(name = "SEQ_CM_CORS_SESN_LSSN_SCTN", sequenceName = "SEQ_CM_CORS_SESN_LSSN_SCTN", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ORDR")
    private Integer order;

    @OneToOne(targetEntity = CmCourseSessionLessonImpl.class)
    @JoinColumn(name = "LESSON_ID")
    private CmCourseSessionLesson lesson;

    @OneToMany(targetEntity = CmCourseSessionLessonContentImpl.class, mappedBy = "section")
    private List<CmCourseSessionLessonContent> contents;

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

    public CmCourseSessionLesson getLesson() {
        return lesson;
    }

    public void setLesson(CmCourseSessionLesson lesson) {
        this.lesson = lesson;
    }

    public List<CmCourseSessionLessonContent> getContents() {
        return contents;
    }

    public void setContents(List<CmCourseSessionLessonContent> contents) {
        this.contents = contents;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
