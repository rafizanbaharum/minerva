package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_QSTN")
@Entity(name = "CmQuestion")
public class CmQuestionImpl implements CmQuestion {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_QSTN")
    @SequenceGenerator(name = "SEQ_CM_QSTN", sequenceName = "SEQ_CM_QSTN", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY")
    private String body;

    @OneToOne(targetEntity = CmQuizSectionImpl.class)
    @JoinColumn(name = "SECTION_ID")
    private CmQuizSection section;

    @OneToMany(targetEntity = CmAnswerImpl.class, mappedBy = "question")
    private List<CmAnswer> answers;

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

    public CmQuizSection getSection() {
        return section;
    }

    public void setSection(CmQuizSection section) {
        this.section = section;
    }

    public List<CmAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<CmAnswer> answers) {
        this.answers = answers;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
