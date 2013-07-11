package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmQuiz;
import net.canang.minerva.core.model.CmQuizSection;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmQuizImpl extends CmAssessmentImpl implements CmQuiz {

    private String title;
    private String description;
    private List<CmQuizSection> sections;

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

    public List<CmQuizSection> getSections() {
        return sections;
    }

    public void setSections(List<CmQuizSection> sections) {
        this.sections = sections;
    }
}
