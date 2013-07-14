package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseQuiz extends CmAssessment, CmShareable {

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    CmCourseModule getModule();

    void setModule(CmCourseModule module);

    List<CmCourseQuizSection> getSections();

    void setSections(List<CmCourseQuizSection> sections);
}
