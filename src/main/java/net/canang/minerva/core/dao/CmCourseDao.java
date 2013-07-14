package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmCourse;
import net.canang.minerva.core.model.CmCourseModule;
import net.canang.minerva.core.model.CmFaculty;
import net.canang.minerva.core.model.CmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
public interface CmCourseDao {

    // finders

    CmCourse findById(Long id);

    CmCourse findByCode(String code);

    List<CmCourse> find(Integer offset, Integer limit);

    List<CmCourse> find(CmFaculty faculty, Integer offset, Integer limit);

    List<CmCourse> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmCourse course, CmUser user);

    void update(CmCourse course, CmUser user);

    void deactivate(CmCourse course, CmUser user);

    void remove(CmCourse course, CmUser user);

    void addModule(CmCourse course, CmCourseModule module, CmUser user);

    void addModules(CmCourse course, List<CmCourseModule> modules, CmUser user);

}
