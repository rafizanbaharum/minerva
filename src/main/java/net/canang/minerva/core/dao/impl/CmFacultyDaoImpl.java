package net.canang.minerva.core.dao.impl;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */

import net.canang.minerva.core.dao.CmFacultyDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.CmFaculty;
import net.canang.minerva.core.model.CmMetaState;
import net.canang.minerva.core.model.impl.CmFacultyImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository("facultyDao")
public class CmFacultyDaoImpl extends DaoSupport<Long, CmFaculty, CmFacultyImpl> implements CmFacultyDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmFaculty findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmFaculty) session.get(CmFacultyImpl.class, id);
    }

    @Override
    public CmFaculty findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmFaculty a where a.code = :code");
        query.setString("code", code);
        return (CmFaculty) query.uniqueResult();
    }

    @Override
    public List<CmFaculty> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmFaculty a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmFaculty> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmFaculty a where " +
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
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmFaculty a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }


    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmFaculty a where " +
                "(a.code like upper(:filter) " +
                "or upper(a.description) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }


    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}
