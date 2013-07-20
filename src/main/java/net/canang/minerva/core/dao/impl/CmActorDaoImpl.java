package net.canang.minerva.core.dao.impl;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */

import net.canang.minerva.core.dao.CmActorDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.*;
import net.canang.minerva.core.model.impl.CmActorImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository("actorDao")
public class CmActorDaoImpl extends DaoSupport<Long, CmActor, CmActorImpl> implements CmActorDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmActor findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmActor) session.get(CmActorImpl.class, id);
    }

    @Override
    public CmActor findByIdentityNo(String identityNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmActor a where " +
                "a.identityNo = :identityNo " +
                "and a.metadata.state = :state ");
        query.setString("identityNo", identityNo);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return (CmActor) query.uniqueResult();
    }

    @Override
    public CmActor findByNricNo(String nricNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmActor a where " +
                "a.nricNo = :nricNo " +
                "and a.metadata.state = :state ");
        query.setString("nricNo", nricNo);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return (CmActor) query.uniqueResult();
    }

    @Override
    public List<CmActor> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmActor a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmActor> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmActor a where " +
                "(a.code like upper(:filter) " +
                "or upper(a.description) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmActor> find(CmActorType type, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmActor a where " +
                "a.actorType = :actorType " +
                "and a.metadata.state = :state");
        query.setInteger("actorType", type.ordinal());
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmActor> find(CmActorType type, String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmActor a where " +
                "(a.identityNo like upper(:filter) " +
                "or upper(a.name) like upper(:filter)) " +
                "and a.actorType = :actorType " +
                "and a.metadata.state = :state");
        query.setInteger("actorType", type.ordinal());
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmActor a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmActor a where " +
                "(a.name like upper(:filter) " +
                "or upper(a.identityNo) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(CmActorType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmActor a where " +
                "a.actorType = :actorType " +
                "and a.metadata.state = :state");
        query.setInteger("actorType", type.ordinal());
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}
