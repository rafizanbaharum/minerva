package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseSessionLessonSection extends CmMetaObject {

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    Integer getOrder();

    void setOrder(Integer order);

    CmCourseSessionLesson getLesson();

    void setLesson(CmCourseSessionLesson lesson);

    List<CmCourseSessionLessonContent> getContents();

    void setContents(List<CmCourseSessionLessonContent> contents);
}
