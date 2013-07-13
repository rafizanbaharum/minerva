package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
@Table(name = "CM_CORS_SESN_QUIZ_SCTN")
@Entity(name = "CmCourseSessionQuizSection")
public class CmCourseSessionQuizSectionImpl implements CmCourseSessionQuizSection {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_SESN_QUIZ_SCTN")
    @SequenceGenerator(name = "SEQ_CM_CORS_SESN_QUIZ_SCTN", sequenceName = "SEQ_CM_CORS_SESN_QUIZ_SCTN", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne(targetEntity = CmCourseSessionQuizImpl.class)
    @JoinColumn(name = "QUIZ_ID")
    private CmCourseSessionQuiz quiz;

    @OneToMany(targetEntity = CmCourseSessionQuestionImpl.class, mappedBy = "section")
    private List<CmCourseSessionQuestion> questions;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CmCourseSessionQuiz getQuiz() {
        return quiz;
    }

    public void setQuiz(CmCourseSessionQuiz quiz) {
        this.quiz = quiz;
    }

    public List<CmCourseSessionQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<CmCourseSessionQuestion> questions) {
        this.questions = questions;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
