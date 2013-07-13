package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmAnswer;
import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmQuestion;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
@Table(name = "CM_ANSR")
@Entity(name = "CmAnswer")
public class CmAnswerImpl implements CmAnswer {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_ANSR")
    @SequenceGenerator(name = "SEQ_CM_ANSR", sequenceName = "SEQ_CM_ANSR", allocationSize = 1)
    private Long id;

    @Column(name = "TXT")
    private String text;

    @Column(name = "ORDR")
    private Integer order;

    @Column(name = "CORRECT")
    private boolean correct;

    @OneToOne(targetEntity = CmQuestionImpl.class)
    @JoinColumn(name = "QUESTION_ID")
    private CmQuestion question;

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

    public CmQuestion getQuestion() {
        return question;
    }

    public void setQuestion(CmQuestion question) {
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

