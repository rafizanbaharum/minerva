package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseAssessmentType;
import net.canang.minerva.core.model.CmCourseQuiz;
import net.canang.minerva.core.model.CmCourseQuizSection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_QUIZ")
@Entity(name = "CmCourseQuiz")
public class CmCourseQuizImpl extends CmCourseAssessmentImpl implements CmCourseQuiz {

    @OneToMany(targetEntity = CmCourseQuizSectionImpl.class, mappedBy = "quiz")
    private List<CmCourseQuizSection> sections;

    public CmCourseQuizImpl() {
        setAssessmentType(CmCourseAssessmentType.QUIZ);
    }

    public List<CmCourseQuizSection> getSections() {
        return sections;
    }

    public void setSections(List<CmCourseQuizSection> sections) {
        this.sections = sections;
    }
}
