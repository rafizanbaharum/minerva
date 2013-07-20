package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseLessonContent extends CmMetaObject {

    String getTitle();

    void setTitle(String title);

    String getBody();

    void setBody(String body);

    Integer getOrder();

    void setOrder(Integer order);

    CmCourseLessonSection getSection();

    void setSection(CmCourseLessonSection section);
}
