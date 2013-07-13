package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmActor;
import net.canang.minerva.core.model.CmGroup;
import net.canang.minerva.core.model.CmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
public interface CmUserDao {

    CmUser findById(Long id);

    CmUser findByUsername(String username);

    CmUser findByActor(CmActor actor);

    CmUser findByRealName(String realname);

    List<CmUser> find(Integer offset, Integer limit);

    List<CmUser> find(String filter, Integer offset, Integer limit);

    List<CmGroup> findUserGroups(CmUser user);

    Integer count();

    Integer count(String filter);

    boolean isExists(String username);

    // cruds

    void save(CmUser suser, CmUser user);

    void update(CmUser suser, CmUser user);

    void deactivate(CmUser suser, CmUser user);

    void remove(CmUser suser, CmUser user);


}
