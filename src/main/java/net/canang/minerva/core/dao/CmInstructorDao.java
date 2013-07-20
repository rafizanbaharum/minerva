package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmInstructor;
import net.canang.minerva.core.model.CmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/20/13
 */
public interface CmInstructorDao {

    CmInstructor findById(Long id);

    CmInstructor findByMatrixNo(String matrixId);

    List<CmInstructor> find(Integer offset, Integer limit);

    List<CmInstructor> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    void save(CmInstructor instructor, CmUser user);

    void update(CmInstructor instructor, CmUser user);

    void deactivate(CmInstructor instructor, CmUser user);

}
