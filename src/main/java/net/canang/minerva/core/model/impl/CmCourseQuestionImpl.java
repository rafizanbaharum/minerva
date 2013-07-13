package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_QSTN")
@Entity(name = "CmCourseQuestion")
public class CmCourseQuestionImpl implements CmCourseQuestion {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_QSTN")
    @SequenceGenerator(name = "SEQ_CM_CORS_QSTN", sequenceName = "SEQ_CM_CORS_QSTN", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY")
    private String body;

    @OneToOne(targetEntity = CmCourseQuizSectionImpl.class)
    @JoinColumn(name = "SECTION_ID")
    private CmCourseQuizSection section;

    @OneToMany(targetEntity = CmAnswerImpl.class, mappedBy = "question")
    private List<CmCourseAnswer> answers;

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

    public CmCourseQuizSection getSection() {
        return section;
    }

    public void setSection(CmCourseQuizSection section) {
        this.section = section;
    }

    public List<CmCourseAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<CmCourseAnswer> answers) {
        this.answers = answers;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
