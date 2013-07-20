package net.canang.minerva.core.dao.impl;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */

import net.canang.minerva.core.dao.CmCourseDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.*;
import net.canang.minerva.core.model.impl.CmCourseImpl;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 */
@Repository("courseDao")
public class CmCourseDaoImpl extends DaoSupport<Long, CmCourse, CmCourseImpl> implements CmCourseDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmCourse findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourse) session.get(CmCourseImpl.class, id);
    }

    @Override
    public CmCourse findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourse a where a.code = :code");
        query.setString("code", code);
        return (CmCourse) query.uniqueResult();
    }

    @Override
    public List<CmCourse> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourse a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmCourse> find(CmFaculty faculty, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourse a where " +
                "a.department.faculty = :department " +
                "and a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmCourse> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourse a where " +
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
        Query query = session.createQuery("select count(a) from CmCourse a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }


    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmCourse a where " +
                "(a.code like upper(:filter) " +
                "or upper(a.description) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    public void addModule(CmCourse course, CmCourseModule module, CmUser user) {
        // sanity check
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

    public void updateModule(CmCourse course, CmCourseModule module, CmUser user) {
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

    public void removeModule(CmCourse course, CmCourseModule module, CmUser user) {
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

    public void addModules(CmCourse course, List<CmCourseModule> modules, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseModule module : modules) {
            addModule(course, module, user);
        }
    }

    public void updateModules(CmCourse course, List<CmCourseModule> modules, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseModule module : modules) {
            updateModule(course, module, user);
        }
    }

    public void removeModules(CmCourse course, List<CmCourseModule> modules, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseModule module : modules) {
            removeModule(course, module, user);
        }
    }


    public void addAsset(CmCourse course, CmCourseAsset asset, CmUser user) {
        // sanity check
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        asset.setCourse(course);

        // prepare metadata
        CmMetadata metadata = new CmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        metadata.setState(CmMetaState.ACTIVE);
        asset.setMetadata(metadata);
        session.save(asset);
    }

    public void updateAsset(CmCourse course, CmCourseAsset asset, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        asset.setCourse(course);

        // prepare metadata
        CmMetadata metadata = asset.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        asset.setMetadata(metadata);
        session.update(asset);
    }

    public void removeAsset(CmCourse course, CmCourseAsset asset, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        asset.setCourse(course);

        // prepare metadata
        CmMetadata metadata = asset.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        metadata.setState(CmMetaState.INACTIVE);
        asset.setMetadata(metadata);
        session.update(asset);
    }

    public void addAssets(CmCourse course, List<CmCourseAsset> assets, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseAsset asset : assets) {
            addAsset(course, asset, user);
        }
    }

    public void updateAssets(CmCourse course, List<CmCourseAsset> assets, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseAsset asset : assets) {
            updateAsset(course, asset, user);
        }
    }

    public void removeAssets(CmCourse course, List<CmCourseAsset> assets, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseAsset asset : assets) {
            removeAsset(course, asset, user);
        }
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}
