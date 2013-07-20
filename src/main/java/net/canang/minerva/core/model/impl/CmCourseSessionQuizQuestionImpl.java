package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseSessionQuizQuestion;
import net.canang.minerva.core.model.CmCourseSessionQuizSection;
import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmQuestionType;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
@Table(name = "CM_CORS_SESN_QUIZ_QSTN")
@Entity(name = "CmCourseSessionQuizQuestion")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CmCourseSessionQuizQuestionImpl implements CmCourseSessionQuizQuestion {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_SESN_QUIZ_QSTN")
    @SequenceGenerator(name = "SEQ_CM_CORS_SESN_QUIZ_QSTN", sequenceName = "SEQ_CM_CORS_SESN_QUIZ_QSTN", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY")
    private String body;

    @Column(name = "ANSWER_CODE")
    private String answerCode;

    @Column(name = "ORDR")
    private Integer order;

    @Column(name = "QUESTION_TYPE")
    private CmQuestionType questionType;

    @OneToOne(targetEntity = CmCourseSessionQuizSectionImpl.class)
    @JoinColumn(name = "SECTION_ID")
    private CmCourseSessionQuizSection section;

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

    public String getAnswerCode() {
        return answerCode;
    }

    public void setAnswerCode(String answerCode) {
        this.answerCode = answerCode;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public CmQuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(CmQuestionType questionType) {
        this.questionType = questionType;
    }

    public CmCourseSessionQuizSection getSection() {
        return section;
    }

    public void setSection(CmCourseSessionQuizSection section) {
        this.section = section;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
