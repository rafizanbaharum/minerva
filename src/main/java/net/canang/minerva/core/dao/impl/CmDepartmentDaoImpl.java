package net.canang.minerva.core.dao.impl;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */

import net.canang.minerva.core.dao.CmDepartmentDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.CmDepartment;
import net.canang.minerva.core.model.CmFaculty;
import net.canang.minerva.core.model.CmMetaState;
import net.canang.minerva.core.model.impl.CmDepartmentImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository("departmentDao")
public class CmDepartmentDaoImpl extends DaoSupport<Long, CmDepartment, CmDepartmentImpl> implements CmDepartmentDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmDepartment findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmDepartment) session.get(CmDepartmentImpl.class, id);
    }

    @Override
    public CmDepartment findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmDepartment a where a.code = :code");
        query.setString("code", code);
        return (CmDepartment) query.uniqueResult();
    }

    @Override
    public List<CmDepartment> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmDepartment a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmDepartment> find(CmFaculty faculty, Integer offset, Integer limit) {
        return null;  // TODO:

    }

    @Override
    public List<CmDepartment> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmDepartment a where " +
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
        Query query = session.createQuery("select count(a) from CmDepartment a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }


    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmDepartment a where " +
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
