package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmFaculty;
import net.canang.minerva.core.model.CmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
public interface CmFacultyDao {
    
    // finders

    CmFaculty findById(Long id);

    CmFaculty findByCode(String code);

    List<CmFaculty> find(Integer offset, Integer limit);

    List<CmFaculty> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmFaculty faculty, CmUser user);

    void update(CmFaculty faculty, CmUser user);

    void deactivate(CmFaculty faculty, CmUser user);

    void remove(CmFaculty faculty, CmUser user);
    
}
