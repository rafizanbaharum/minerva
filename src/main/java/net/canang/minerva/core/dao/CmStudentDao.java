package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmStudent;
import net.canang.minerva.core.model.CmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/20/13
 */
public interface CmStudentDao {

    CmStudent findById(Long id);

    CmStudent findByMatrixNo(String matrixId);

    List<CmStudent> find(Integer offset, Integer limit);

    List<CmStudent> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    void save(CmStudent student, CmUser user);

    void update(CmStudent student, CmUser user);

    void deactivate(CmStudent student, CmUser user);

}

