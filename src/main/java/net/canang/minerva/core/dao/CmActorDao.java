package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmActor;
import net.canang.minerva.core.model.CmActorType;
import net.canang.minerva.core.model.CmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/20/13
 */
public interface CmActorDao {

    CmActor findById(Long id);

    CmActor findByIdentityNo(String identityNo);

    CmActor findByNricNo(String nricNo);

    List<CmActor> find(Integer offset, Integer limit);

    List<CmActor> find(String filter, Integer offset, Integer limit);

    List<CmActor> find(CmActorType type, Integer offset, Integer limit);

    List<CmActor> find(CmActorType type, String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    Integer count(CmActorType type);

    void save(CmActor actor, CmUser user);

    void update(CmActor actor, CmUser user);

    void deactivate(CmActor actor, CmUser user);
}
