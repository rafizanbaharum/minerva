package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/14/13
 */
public interface CmCourseAssetDao {

    // finders

    CmCourseAsset findById(Long id);

    CmCourseAsset findByCode(String code);

    List<CmCourseAsset> find(Integer offset, Integer limit);

    List<CmCourseAsset> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmCourseAsset course, CmUser user);

    void update(CmCourseAsset course, CmUser user);

    void deactivate(CmCourseAsset course, CmUser user);

    void remove(CmCourseAsset course, CmUser user);
}
