package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmQuestion;
import net.canang.minerva.core.model.CmQuiz;
import net.canang.minerva.core.model.CmQuizSection;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_QUIZ_SCTN")
@Entity(name = "CmQuizSection")
public class CmQuizSectionImpl implements CmQuizSection {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_SCTN")
    @SequenceGenerator(name = "SEQ_CM_SCTN", sequenceName = "SEQ_CM_SCTN", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne(targetEntity = CmQuizImpl.class)
    @JoinColumn(name = "QUIZ_ID")
    private CmQuiz quiz;

    @OneToMany(targetEntity = CmQuestionImpl.class, mappedBy = "section")
    private List<CmQuestion> questions;

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

    public List<CmQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<CmQuestion> questions) {
        this.questions = questions;
    }

    public CmQuiz getQuiz() {
        return quiz;
    }

    public void setQuiz(CmQuiz quiz) {
        this.quiz = quiz;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
