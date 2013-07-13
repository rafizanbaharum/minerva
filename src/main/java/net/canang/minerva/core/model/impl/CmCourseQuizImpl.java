package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseQuiz;
import net.canang.minerva.core.model.CmCourseQuizSection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_QUIZ")
@Entity(name = "CmQuiz")
public class CmCourseQuizImpl extends CmAssessmentImpl implements CmCourseQuiz {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(targetEntity = CmCourseQuizSectionImpl.class, mappedBy = "quiz")
    private List<CmCourseQuizSection> sections;

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

    public List<CmCourseQuizSection> getSections() {
        return sections;
    }

    public void setSections(List<CmCourseQuizSection> sections) {
        this.sections = sections;
    }
}
