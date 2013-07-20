package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseQuiz extends CmCourseAssessment, CmShareable {

    List<CmCourseQuizSection> getSections();

    void setSections(List<CmCourseQuizSection> sections);
}
