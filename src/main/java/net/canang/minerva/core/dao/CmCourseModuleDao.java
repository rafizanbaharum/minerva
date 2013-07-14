package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmCourseLesson;
import net.canang.minerva.core.model.CmCourseModule;
import net.canang.minerva.core.model.CmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
public interface CmCourseModuleDao {

    // finders

    CmCourseModule findById(Long id);

    CmCourseModule findByCode(String code);

    List<CmCourseModule> find(Integer offset, Integer limit);

    List<CmCourseModule> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmCourseModule module, CmUser user);

    void update(CmCourseModule module, CmUser user);

    void deactivate(CmCourseModule module, CmUser user);

    void remove(CmCourseModule module, CmUser user);

    void addLesson(CmCourseModule module, CmCourseLesson lesson, CmUser user);

    void addLessons(CmCourseModule module, List<CmCourseLesson> lesson, CmUser user);

}
