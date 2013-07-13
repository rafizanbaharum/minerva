package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
@Table(name = "CM_CORS_SESN_QSTN")
@Entity(name = "CmCourseSessionQuestion")
public class CmCourseSessionQuestionImpl implements CmCourseSessionQuestion {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_SESN_QSTN")
    @SequenceGenerator(name = "SEQ_CM_CORS_SESN_QSTN", sequenceName = "SEQ_CM_CORS_SESN_QSTN", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY")
    private String body;

    @OneToOne(targetEntity = CmCourseSessionQuizSectionImpl.class)
    @JoinColumn(name = "SECTION_ID")
    private CmCourseSessionQuizSection section;

    @OneToMany(targetEntity = CmCourseSessionAnswerImpl.class, mappedBy = "question")
    private List<CmCourseSessionAnswer> answers;

    @Embedded
    private CmMetadata metadata = new CmMetadata();

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

    public CmCourseSessionQuizSection getSection() {
        return section;
    }

    public void setSection(CmCourseSessionQuizSection section) {
        this.section = section;
    }

    public List<CmCourseSessionAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<CmCourseSessionAnswer> answers) {
        this.answers = answers;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
