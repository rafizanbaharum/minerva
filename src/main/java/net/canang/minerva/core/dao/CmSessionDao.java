package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
public interface CmSessionDao {

    // finders

    CmSession findById(Long id);

    CmSession findByCode(String code);

    List<CmSession> find(Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmSession session, CmUser user);

    void update(CmSession session, CmUser user);

    void deactivate(CmSession session, CmUser user);

    void remove(CmSession session, CmUser user);

}