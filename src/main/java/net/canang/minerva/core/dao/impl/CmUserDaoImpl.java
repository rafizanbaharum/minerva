package net.canang.minerva.core.dao.impl;

import net.canang.minerva.core.dao.CmPrincipalDao;
import net.canang.minerva.core.dao.CmUserDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.CmActor;
import net.canang.minerva.core.model.CmGroup;
import net.canang.minerva.core.model.CmMetaState;
import net.canang.minerva.core.model.CmUser;
import net.canang.minerva.core.model.impl.CmUserImpl;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
@Repository("userDao")
public class CmUserDaoImpl extends DaoSupport<Long, CmUser, CmUserImpl> implements CmUserDao {

    private static final Logger log = Logger.getLogger(CmUserDaoImpl.class);

    @Autowired
    private CmPrincipalDao principalDao;


    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public List<CmGroup> findUserGroups(CmUser user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from CmGroup r inner join r.groupMembers m where m.principal = :user");
        query.setEntity("user", user);
        return (List<CmGroup>) query.list();
    }

    @Override
    public boolean isExists(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from CmUser u where " +
                "u.name = :username");
        query.setString("username", username);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public CmUser findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmUser) session.get(CmUserImpl.class, id);
    }

    @Override
    public CmUser findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CmUser u where u.name = :username and u.metadata.state = :state");
        query.setString("username", username);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return (CmUser) query.uniqueResult();
    }

    @Override
    public CmUser findByActor(CmActor actor) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CmUser u where u.actor  = :actor");
        query.setEntity("actor", actor);
        return (CmUser) query.uniqueResult();
    }

    public CmUser findByRealName(String realname) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CmUser u where u.realname = :realname");
        query.setString("realname", realname);
        return (CmUser) query.uniqueResult();
    }

    @Override
    public List<CmUser> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from CmUser s");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<CmUser>) query.list();
    }

    @Override
    public List<CmUser> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from CmUser s where (s.name like :filter or s.realname like upper(:filter))");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<CmUser>) query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(u) from CmUser u");
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from CmUser s where s.name like :filter " +
                "or s.realname like upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }
}
