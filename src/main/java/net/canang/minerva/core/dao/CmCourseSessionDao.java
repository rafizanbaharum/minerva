package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
public interface CmCourseSessionDao {

    // finders

    CmCourseSession findById(Long id);

    CmCourseSession findByCode(String code);

    List<CmCourseSession> find(Integer offset, Integer limit);

    List<CmCourseSession> find(CmSession session);

    List<CmCourseSession> find(CmSession session, CmDepartment department);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmCourseSession course, CmUser user);

    void update(CmCourseSession course, CmUser user);

    void deactivate(CmCourseSession course, CmUser user);

    void remove(CmCourseSession course, CmUser user);

    void addModule(CmCourseSession course, CmCourseSessionModule module, CmUser user);

    void addModules(CmCourseSession course, List<CmCourseSessionModule> modules, CmUser user);

//    void addAsset(CmCourseSession course, CmCourseSessionAsset asset, CmUser user);
//
//    void addAssets(CmCourseSession course, List<CmCourseSessionAsset> assets, CmUser user);
//
}
