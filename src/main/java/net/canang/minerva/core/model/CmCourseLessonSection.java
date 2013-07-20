package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseLessonSection extends CmMetaObject {

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    Integer getOrder();

    void setOrder(Integer order);

    CmCourseLesson getLesson();

    void setLesson(CmCourseLesson lesson);

    List<CmCourseLessonContent> getContents();

    void setContents(List<CmCourseLessonContent> contents);
}
