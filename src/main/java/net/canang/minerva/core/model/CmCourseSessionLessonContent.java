package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseSessionLessonContent extends CmMetaObject {

    String getTitle();

    void setTitle(String title);

    String getBody();

    void setBody(String body);

    Integer getOrder();

    void setOrder(Integer order);

    CmCourseSessionLessonSection getSection();

    void setSection(CmCourseSessionLessonSection section);
}
