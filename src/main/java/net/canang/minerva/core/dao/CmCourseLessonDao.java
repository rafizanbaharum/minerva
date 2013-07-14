package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmCourseContent;
import net.canang.minerva.core.model.CmCourseLesson;
import net.canang.minerva.core.model.CmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
@Deprecated
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

    void addContent(CmCourseLesson lesson, CmCourseContent content, CmUser user);

    void addContents(CmCourseLesson lesson, List<CmCourseContent> contents, CmUser user);

}
