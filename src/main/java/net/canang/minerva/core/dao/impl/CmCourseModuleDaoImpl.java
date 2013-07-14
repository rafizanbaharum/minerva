package net.canang.minerva.core.dao.impl;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */

import net.canang.minerva.core.dao.CmCourseModuleDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.*;
import net.canang.minerva.core.model.impl.CmCourseModuleImpl;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 */
@Repository("courseModuleDao")
public class CmCourseModuleDaoImpl extends DaoSupport<Long, CmCourseModule, CmCourseModuleImpl> implements CmCourseModuleDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmCourseModule findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourseModule) session.get(CmCourseModuleImpl.class, id);
    }

    @Override
    public CmCourseModule findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseModule a where a.code = :code");
        query.setString("code", code);
        return (CmCourseModule) query.uniqueResult();
    }

    @Override
    public List<CmCourseModule> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseModule a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmCourseModule> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseModule a where " +
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
        Query query = session.createQuery("select count(a) from CmCourseModule a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }


    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmCourseModule a where " +
                "(a.code like upper(:filter) " +
                "or upper(a.description) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    public void addLesson(CmCourseModule module, CmCourseLesson lesson, CmUser user) {
        // sanity check
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        lesson.setModule(module);

        // prepare metadata
        CmMetadata metadata = new CmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        metadata.setState(CmMetaState.ACTIVE);
        lesson.setMetadata(metadata);
        session.save(lesson);
    }

    public void updateLesson(CmCourseModule module, CmCourseLesson lesson, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        lesson.setModule(module);

        // prepare metadata
        CmMetadata metadata = lesson.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        lesson.setMetadata(metadata);
        session.update(lesson);
    }

    public void removeLesson(CmCourseModule module, CmCourseLesson lesson, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        lesson.setModule(module);

        // prepare metadata
        CmMetadata metadata = lesson.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        metadata.setState(CmMetaState.INACTIVE);
        lesson.setMetadata(metadata);
        session.update(lesson);
    }

    public void addLessons(CmCourseModule module, List<CmCourseLesson> lessons, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseLesson lesson : lessons) {
            addLesson(module, lesson, user);
        }
    }

    public void updateLessons(CmCourseModule course, List<CmCourseLesson> lessons, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseLesson lesson : lessons) {
            updateLesson(course, lesson, user);
        }
    }

    public void removeLessons(CmCourseModule module, List<CmCourseLesson> lessons, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseLesson lesson : lessons) {
            removeLesson(module, lesson, user);
        }
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}
