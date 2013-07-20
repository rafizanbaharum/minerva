package net.canang.minerva.core.dao.impl;

import net.canang.minerva.core.dao.CmCourseSessionDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.*;
import net.canang.minerva.core.model.impl.CmCourseImpl;
import net.canang.minerva.core.model.impl.CmCourseSessionImpl;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@SuppressWarnings({"unchecked"})
@Repository("courseSessionDao")
public class CmCourseSessionDaoImpl extends DaoSupport<Long, CmCourseSession, CmCourseSessionImpl> implements CmCourseSessionDao {

    @Autowired
    private SessionFactory sessionFactory;


    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmCourseSession findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourseSession) session.get(CmCourseImpl.class, id);
    }

    @Override
    public CmCourseSession findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseSession a where a.code = :code");
        query.setString("code", code);
        return (CmCourseSession) query.uniqueResult();
    }

    @Override
    public List<CmCourseSession> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseSession a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }


    @Override
    public List<CmCourseSession> find(CmSession session) {
        Session sn = sessionFactory.getCurrentSession();
        Query query = sn.createQuery("select cs from CmCourseSession cs where " +
                "cs.session = :session");
        query.setEntity("session", session);
        return (List<CmCourseSession>) query.list();
    }

    @Override
    public List<CmCourseSession> find(CmSession session, CmDepartment department) {
        Session sn = sessionFactory.getCurrentSession();
        Query query = sn.createQuery("select cs from CmCourseSession cs where " +
                "cs.session = :session");
        query.setEntity("session", session);
        query.setEntity("department", department);
        return (List<CmCourseSession>) query.list();
    }


    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmCourseSession a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmCourseSession a where " +
                "(a.code like upper(:filter) " +
                "or upper(a.description) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    public void addModule(CmCourseSession course, CmCourseSessionModule module, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        module.setCourse(course);

        // prepare metadata
        CmMetadata metadata = new CmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        metadata.setState(CmMetaState.ACTIVE);
        module.setMetadata(metadata);
        session.save(module);
    }

    public void updateModule(CmCourseSession course, CmCourseSessionModule module, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        module.setCourse(course);

        // prepare metadata
        CmMetadata metadata = module.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        module.setMetadata(metadata);
        session.update(module);
    }

    public void removeModule(CmCourseSession course, CmCourseSessionModule module, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        module.setCourse(course);

        // prepare metadata
        CmMetadata metadata = module.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        metadata.setState(CmMetaState.INACTIVE);
        module.setMetadata(metadata);
        session.update(module);
    }

    public void addModules(CmCourseSession course, List<CmCourseSessionModule> modules, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionModule module : modules) {
            addModule(course, module, user);
        }
    }

    public void updateModules(CmCourseSession course, List<CmCourseSessionModule> modules, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionModule module : modules) {
            updateModule(course, module, user);
        }
    }

    public void removeModules(CmCourseSession course, List<CmCourseSessionModule> modules, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionModule module : modules) {
            removeModule(course, module, user);
        }
    }

//    public void addAsset(CmCourseSession course, CmCourseAsset asset, CmUser user) {
//        // sanity check
//        Validate.notNull(user, "User cannot be null");
//
//        Session session = sessionFactory.getCurrentSession();
//        asset.setCourse(course);
//
//        // prepare metadata
//        CmMetadata metadata = new CmMetadata();
//        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
//        metadata.setCreator(user.getId());
//        metadata.setState(CmMetaState.ACTIVE);
//        asset.setMetadata(metadata);
//        session.save(asset);
//    }
//
//    public void updateAsset(CmCourseSession course, CmCourseAsset asset, CmUser user) {
//        Validate.notNull(user, "User cannot be null");
//
//        Session session = sessionFactory.getCurrentSession();
//        asset.setCourse(course);
//
//        // prepare metadata
//        CmMetadata metadata = asset.getMetadata();
//        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
//        metadata.setModifier(user.getId());
//        asset.setMetadata(metadata);
//        session.update(asset);
//    }
//
//    public void removeAsset(CmCourseSession course, CmCourseAsset asset, CmUser user) {
//        Validate.notNull(user, "User cannot be null");
//        Session session = sessionFactory.getCurrentSession();
//        asset.setCourse(course);
//
//        // prepare metadata
//        CmMetadata metadata = asset.getMetadata();
//        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
//        metadata.setModifier(user.getId());
//        metadata.setState(CmMetaState.INACTIVE);
//        asset.setMetadata(metadata);
//        session.update(asset);
//    }
//
//    public void addAssets(CmCourseSession course, List<CmCourseAsset> assets, CmUser user) {
//        Validate.notNull(user, "User cannot be null");
//        for (CmCourseAsset asset : assets) {
//            addAsset(course, asset, user);
//        }
//    }
//
//    public void updateAssets(CmCourseSession course, List<CmCourseAsset> assets, CmUser user) {
//        Validate.notNull(user, "User cannot be null");
//        for (CmCourseAsset asset : assets) {
//            updateAsset(course, asset, user);
//        }
//    }
//
//    public void removeAssets(CmCourseSession course, List<CmCourseAsset> assets, CmUser user) {
//        Validate.notNull(user, "User cannot be null");
//        for (CmCourseAsset asset : assets) {
//            removeAsset(course, asset, user);
//        }
//    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================


}
