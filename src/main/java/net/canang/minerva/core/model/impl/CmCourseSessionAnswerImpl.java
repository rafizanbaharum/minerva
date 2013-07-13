package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseSessionAnswer;
import net.canang.minerva.core.model.CmCourseSessionQuestion;
import net.canang.minerva.core.model.CmMetadata;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_CORS_SESN_ANSR")
@Entity(name = "CmCourseSessionAnswer")
public class CmCourseSessionAnswerImpl implements CmCourseSessionAnswer {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_SESN_ANSR")
    @SequenceGenerator(name = "SEQ_CM_CORS_SESN_ANSR", sequenceName = "SEQ_CM_CORS_SESN_ANSR", allocationSize = 1)
    private Long id;

    @Column(name = "TXT")
    private String text;

    @Column(name = "ORDR")
    private Integer order;

    @Column(name = "CORRECT")
    private boolean correct;

    @OneToOne(targetEntity = CmCourseSessionQuestionImpl.class)
    @JoinColumn(name = "QUESTION_ID")
    private CmCourseSessionQuestion question;

    @Embedded
    private CmMetadata metadata;

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

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public CmCourseSessionQuestion getQuestion() {
        return question;
    }

    public void setQuestion(CmCourseSessionQuestion question) {
        this.question = question;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
