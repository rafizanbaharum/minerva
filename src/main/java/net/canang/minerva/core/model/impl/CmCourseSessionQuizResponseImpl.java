package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseSessionQuizResponse;
import net.canang.minerva.core.model.CmMetadata;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_CORS_SESN_QUIZ_RSPN")
@Entity(name = "CmCourseSessionQuizResponse")
public class CmCourseSessionQuizResponseImpl implements CmCourseSessionQuizResponse {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_SESN_QUIZ_RSPN")
    @SequenceGenerator(name = "SEQ_CM_CORS_SESN_QUIZ_RSPN", sequenceName = "SEQ_CM_CORS_SESN_QUIZ_RSPN", allocationSize = 1)
    private Long id;

    @Column(name = "TXT")
    private String text;

    @Column(name = "RESPONSE_CODE")
    private String responseCode;

    @Column(name = "CORRECT")
    private boolean correct;

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

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
