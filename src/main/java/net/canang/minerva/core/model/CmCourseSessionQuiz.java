package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseSessionQuiz extends CmCourseSessionAssessment, CmMetaObject {

    List<CmCourseSessionQuizSection> getSections();

    void setSections(List<CmCourseSessionQuizSection> sections);
}
