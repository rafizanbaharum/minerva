package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseAnswer;
import net.canang.minerva.core.model.CmCourseQuestion;
import net.canang.minerva.core.model.CmMetadata;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
@Table(name = "CM_CORS_ANSR")
@Entity(name = "CmCourseAnswer")
public class CmAnswerImpl implements CmCourseAnswer {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_ANSR")
    @SequenceGenerator(name = "SEQ_CM_CORS_ANSR", sequenceName = "SEQ_CM_CORS_ANSR", allocationSize = 1)
    private Long id;

    @Column(name = "TXT")
    private String text;

    @Column(name = "ORDR")
    private Integer order;

    @Column(name = "CORRECT")
    private boolean correct;

    @OneToOne(targetEntity = CmCourseQuestionImpl.class)
    @JoinColumn(name = "QUESTION_ID")
    private CmCourseQuestion question;

    @Embedded
    private CmMetadata metadata = new CmMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public CmCourseQuestion getQuestion() {
        return question;
    }

    public void setQuestion(CmCourseQuestion question) {
        this.question = question;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}

