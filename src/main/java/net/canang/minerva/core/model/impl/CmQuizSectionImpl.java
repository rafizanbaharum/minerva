package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmQuestion;
import net.canang.minerva.core.model.CmQuizSection;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_QUIZ_SECTION")
@Entity(name = "CmQuizSection")
public class CmQuizSectionImpl implements CmQuizSection {

    private Long id;
    private String title;
    private String description;
    private List<CmQuestion> questions;

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

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
