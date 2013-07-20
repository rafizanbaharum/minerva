package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmCourseSessionLesson;
import net.canang.minerva.core.model.CmCourseSessionLessonContent;
import net.canang.minerva.core.model.CmCourseSessionLessonSection;
import net.canang.minerva.core.model.CmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
public interface CmCourseSessionLessonDao {

    // finders

    CmCourseSessionLesson findById(Long id);

    CmCourseSessionLesson findByCode(String code);

    List<CmCourseSessionLesson> find(Integer offset, Integer limit);

    List<CmCourseSessionLesson> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmCourseSessionLesson lesson, CmUser user);

    void update(CmCourseSessionLesson lesson, CmUser user);

    void deactivate(CmCourseSessionLesson lesson, CmUser user);

    void remove(CmCourseSessionLesson lesson, CmUser user);

    void addSection(CmCourseSessionLesson lesson, CmCourseSessionLessonSection section, CmUser user);

    void addSections(CmCourseSessionLesson lesson, List<CmCourseSessionLessonSection> sections, CmUser user);

    void updateSection(CmCourseSessionLesson lesson, CmCourseSessionLessonSection section, CmUser user);

    void updateSections(CmCourseSessionLesson lesson, List<CmCourseSessionLessonSection> sections, CmUser user);

    void removeSection(CmCourseSessionLesson lesson, CmCourseSessionLessonSection section, CmUser user);

    void removeSections(CmCourseSessionLesson lesson, List<CmCourseSessionLessonSection> sections, CmUser user);

    void addContent(CmCourseSessionLessonSection section, CmCourseSessionLessonContent content, CmUser user);

    void addContents(CmCourseSessionLessonSection section, List<? extends CmCourseSessionLessonContent> contents, CmUser user);

    void updateContent(CmCourseSessionLessonSection section, CmCourseSessionLessonContent content, CmUser user);

    void updateContents(CmCourseSessionLessonSection section, List<? extends CmCourseSessionLessonContent> contents, CmUser user);

    void removeContent(CmCourseSessionLessonSection section, CmCourseSessionLessonContent content, CmUser user);

    void removeContents(CmCourseSessionLessonSection section, List<? extends CmCourseSessionLessonContent> contents, CmUser user);

}
