package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseSessionQuestion extends CmMetaObject {

    String getTitle();

    void setTitle(String title);

    String getBody();

    void setBody(String body);

    CmCourseSessionQuizSection getSection();

    void setSection(CmCourseSessionQuizSection section);

    List<CmCourseSessionAnswer> getAnswers();

    void setAnswers(List<CmCourseSessionAnswer> answers);

}
