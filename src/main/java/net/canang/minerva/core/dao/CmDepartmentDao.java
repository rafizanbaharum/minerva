package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmDepartment;
import net.canang.minerva.core.model.CmFaculty;
import net.canang.minerva.core.model.CmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
public interface CmDepartmentDao {

    // finders

    CmDepartment findById(Long id);

    CmDepartment findByCode(String code);

    List<CmDepartment> find(Integer offset, Integer limit);

    List<CmDepartment> find(CmFaculty faculty, Integer offset, Integer limit);

    List<CmDepartment> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmDepartment department, CmUser user);

    void update(CmDepartment department, CmUser user);

    void deactivate(CmDepartment department, CmUser user);

    void remove(CmDepartment department, CmUser user);

}
