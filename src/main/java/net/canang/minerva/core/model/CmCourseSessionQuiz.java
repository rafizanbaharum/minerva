package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseSessionQuiz extends CmMetaObject {

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    CmCourseSessionModule getModule();

    void setModule(CmCourseSessionModule module);

    List<CmCourseSessionQuizSection> getSections();

    void setSections(List<CmCourseSessionQuizSection> sections);
}
