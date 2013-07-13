package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseSessionAnswer;
import net.canang.minerva.core.model.CmCourseSessionResponse;
import net.canang.minerva.core.model.CmMetadata;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_CORS_SESN_RSPN")
@Entity(name = "CmCourseSessionResponse")
public class CmCourseSessionResponseImpl implements CmCourseSessionResponse {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_SESN_RSPN")
    @SequenceGenerator(name = "SEQ_CM_CORS_SESN_RSPN", sequenceName = "SEQ_CM_CORS_SESN_RSPN", allocationSize = 1)
    private Long id;

    @Column(name = "TXT")
    private String text;

    @Column(name = "PATH")
    private String path;

    @Column(name = "CORRECT")
    private boolean correct;

    @OneToOne(targetEntity = CmCourseSessionAnswerImpl.class)
    @JoinColumn(name = "ANSWER_ID")
    private CmCourseSessionAnswer answer;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public CmCourseSessionAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(CmCourseSessionAnswer answer) {
        this.answer = answer;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
