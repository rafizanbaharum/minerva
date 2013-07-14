package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseQuestion extends CmShareable, CmMetaObject {

    String getTitle();

    void setTitle(String title);

    String getBody();

    void setBody(String body);

    CmCourseQuizSection getSection();

    void setSection(CmCourseQuizSection section);

    List<CmCourseAnswer> getAnswers();

    void setAnswers(List<CmCourseAnswer> answers);

}
