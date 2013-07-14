package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_CORS_CTNT")
@Entity(name = "CmCourseContent")
public class CmCourseContentImpl implements CmCourseContent {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_CTNT")
    @SequenceGenerator(name = "SEQ_CM_CORS_CTNT", sequenceName = "SEQ_CM_CORS_CTNT", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Lob
    @Column(name = "BODY")
    private String body;

    @OneToOne(targetEntity = CmCourseLessonImpl.class)
    @JoinColumn(name = "LESSON_ID")
    private CmCourseLesson lesson;

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public CmCourseLesson getLesson() {
        return lesson;
    }

    public void setLesson(CmCourseLesson lesson) {
        this.lesson = lesson;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
