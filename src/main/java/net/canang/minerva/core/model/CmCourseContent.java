package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseContent extends CmMetaObject {

    String getTitle();

    void setTitle(String title);

    String getBody();

    void setBody(String body);

    CmCourseLesson getLesson();

    void setLesson(CmCourseLesson lesson);
}
