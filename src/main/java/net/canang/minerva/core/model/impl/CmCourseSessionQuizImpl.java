package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
@Table(name = "CM_CORS_SESN_QUIZ")
@Entity(name = "CmCourseSessionQuiz")
public class CmCourseSessionQuizImpl extends CmCourseSessionAssessmentImpl implements CmCourseSessionQuiz {

    @OneToMany(targetEntity = CmCourseSessionQuizSectionImpl.class, mappedBy = "quiz")
    private List<CmCourseSessionQuizSection> sections;

    @Embedded
    private CmMetadata metadata = new CmMetadata();

    public List<CmCourseSessionQuizSection> getSections() {
        return sections;
    }

    public void setSections(List<CmCourseSessionQuizSection> sections) {
        this.sections = sections;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
