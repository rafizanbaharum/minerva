package net.canang.minerva.core.dao.impl;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */

import net.canang.minerva.core.dao.CmCourseLessonDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.*;
import net.canang.minerva.core.model.impl.CmCourseLessonImpl;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 */
@Repository("courseLessonDao")
public class CmCourseLessonDaoImpl extends DaoSupport<Long, CmCourseLesson, CmCourseLessonImpl> implements CmCourseLessonDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmCourseLesson findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourseLesson) session.get(CmCourseLessonImpl.class, id);
    }

    @Override
    public CmCourseLesson findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseLesson a where a.code = :code");
        query.setString("code", code);
        return (CmCourseLesson) query.uniqueResult();
    }

    @Override
    public List<CmCourseLesson> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseLesson a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmCourseLesson> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseLesson a where " +
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
        Query query = session.createQuery("select count(a) from CmCourseLesson a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }


    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmCourseLesson a where " +
                "(a.code like upper(:filter) " +
                "or upper(a.description) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    public void addContent(CmCourseLesson module, CmCourseContent content, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        content.setLesson(module);

        // prepare metadata
        CmMetadata metadata = new CmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        metadata.setState(CmMetaState.ACTIVE);
        content.setMetadata(metadata);
        session.save(content);
    }

    public void updateContent(CmCourseLesson module, CmCourseContent content, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        content.setLesson(module);

        // prepare metadata
        CmMetadata metadata = content.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        content.setMetadata(metadata);
        session.update(content);
    }

    public void removeContent(CmCourseLesson module, CmCourseContent content, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        content.setLesson(module);

        // prepare metadata
        CmMetadata metadata = content.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        metadata.setState(CmMetaState.INACTIVE);
        content.setMetadata(metadata);
        session.update(content);
    }

    public void addContents(CmCourseLesson module, List<CmCourseContent> contents, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseContent lesson : contents) {
            addContent(module, lesson, user);
        }
    }

    public void updateContents(CmCourseLesson course, List<CmCourseContent> contents, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseContent lesson : contents) {
            updateContent(course, lesson, user);
        }
    }

    public void removeContents(CmCourseLesson module, List<CmCourseContent> contents, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseContent lesson : contents) {
            removeContent(module, lesson, user);
        }
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}
