package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
public interface CmCourseLessonDao {

    // finders

    CmCourseLesson findById(Long id);

    CmCourseLesson findByCode(String code);

    List<CmCourseLesson> find(Integer offset, Integer limit);

    List<CmCourseLesson> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmCourseLesson lesson, CmUser user);

    void update(CmCourseLesson lesson, CmUser user);

    void deactivate(CmCourseLesson lesson, CmUser user);

    void remove(CmCourseLesson lesson, CmUser user);

    void addSection(CmCourseLesson lesson, CmCourseLessonSection section, CmUser user);

    void addSections(CmCourseLesson lesson, List<CmCourseLessonSection> sections, CmUser user);

    void updateSection(CmCourseLesson lesson, CmCourseLessonSection section, CmUser user);

    void updateSections(CmCourseLesson lesson, List<CmCourseLessonSection> sections, CmUser user);

    void removeSection(CmCourseLesson lesson, CmCourseLessonSection section, CmUser user);

    void removeSections(CmCourseLesson lesson, List<CmCourseLessonSection> sections, CmUser user);

    void addContent(CmCourseLessonSection section, CmCourseLessonContent content, CmUser user);

    void addContents(CmCourseLessonSection section, List<? extends CmCourseLessonContent> contents, CmUser user);

    void updateContent(CmCourseLessonSection section, CmCourseLessonContent content, CmUser user);

    void updateContents(CmCourseLessonSection section, List<? extends CmCourseLessonContent> contents, CmUser user);

    void removeContent(CmCourseLessonSection section, CmCourseLessonContent content, CmUser user);

    void removeContents(CmCourseLessonSection section, List<? extends CmCourseLessonContent> contents, CmUser user);

}
