package net.canang.minerva.core.dao.impl;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */

import net.canang.minerva.core.dao.CmCourseAssetDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.CmCourseAsset;
import net.canang.minerva.core.model.CmMetaState;
import net.canang.minerva.core.model.impl.CmCourseAssetImpl;
import net.canang.minerva.core.model.impl.CmCourseImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository("courseAssetDao")
public class CmCourseAssetDaoImpl extends DaoSupport<Long, CmCourseAsset, CmCourseAssetImpl> implements CmCourseAssetDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmCourseAsset findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourseAsset) session.get(CmCourseImpl.class, id);
    }

    @Override
    public CmCourseAsset findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseAsset a where a.code = :code");
        query.setString("code", code);
        return (CmCourseAsset) query.uniqueResult();
    }

    @Override
    public List<CmCourseAsset> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseAsset a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmCourseAsset> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseAsset a where " +
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
        Query query = session.createQuery("select count(a) from CmCourseAsset a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmCourseAsset a where " +
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
