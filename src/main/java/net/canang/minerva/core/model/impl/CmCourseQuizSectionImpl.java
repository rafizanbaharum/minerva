package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseQuizQuestion;
import net.canang.minerva.core.model.CmCourseQuizSection;
import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmCourseQuiz;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_QUIZ_SCTN")
@Entity(name = "CmCourseQuizSection")
public class CmCourseQuizSectionImpl implements CmCourseQuizSection {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_QUIZ_SCTN")
    @SequenceGenerator(name = "SEQ_CM_CORS_QUIZ_SCTN", sequenceName = "SEQ_CM_CORS_QUIZ_SCTN", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ORDR")
    private Integer order;

    @OneToOne(targetEntity = CmCourseQuizImpl.class)
    @JoinColumn(name = "QUIZ_ID")
    private CmCourseQuiz quiz;

    @OneToMany(targetEntity = CmCourseQuizQuestionImpl.class, mappedBy = "section")
    private List<CmCourseQuizQuestion> questions;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<CmCourseQuizQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<CmCourseQuizQuestion> questions) {
        this.questions = questions;
    }

    public CmCourseQuiz getQuiz() {
        return quiz;
    }

    public void setQuiz(CmCourseQuiz quiz) {
        this.quiz = quiz;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
