package net.canang.minerva.core.dao.impl;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */

import net.canang.minerva.core.dao.CmCourseSessionLessonDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.*;
import net.canang.minerva.core.model.impl.CmCourseSessionLessonImpl;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 */
@Repository("courseSessionLessonDao")
public class CmCourseSessionLessonDaoImpl extends DaoSupport<Long, CmCourseSessionLesson, CmCourseSessionLessonImpl> implements CmCourseSessionLessonDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmCourseSessionLesson findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourseSessionLesson) session.get(CmCourseSessionLessonImpl.class, id);
    }

    @Override
    public CmCourseSessionLesson findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseSessionLesson a where a.code = :code");
        query.setString("code", code);
        return (CmCourseSessionLesson) query.uniqueResult();
    }

    @Override
    public List<CmCourseSessionLesson> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseSessionLesson a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmCourseSessionLesson> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseSessionLesson a where " +
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
        Query query = session.createQuery("select count(a) from CmCourseSessionLesson a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }


    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmCourseSessionLesson a where " +
                "(a.code like upper(:filter) " +
                "or upper(a.description) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public void addSection(CmCourseSessionLesson lesson, CmCourseSessionLessonSection section, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        section.setLesson(lesson);

        // prepare metadata
        CmMetadata metadata = new CmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        metadata.setState(CmMetaState.ACTIVE);
        section.setMetadata(metadata);
        session.save(section);
    }

    @Override
    public void updateSection(CmCourseSessionLesson lesson, CmCourseSessionLessonSection section, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        section.setLesson(lesson);

        // prepare metadata
        CmMetadata metadata = section.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        section.setMetadata(metadata);
        session.update(section);
    }

    @Override
    public void removeSection(CmCourseSessionLesson lesson, CmCourseSessionLessonSection section, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        section.setLesson(lesson);

        // prepare metadata
        CmMetadata metadata = section.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        metadata.setState(CmMetaState.INACTIVE);
        section.setMetadata(metadata);
        session.update(section);
    }

    @Override
    public void addSections(CmCourseSessionLesson lesson, List<CmCourseSessionLessonSection> sections, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionLessonSection section : sections) {
            addSection(lesson, section, user);
        }
    }

    @Override
    public void updateSections(CmCourseSessionLesson course, List<CmCourseSessionLessonSection> sections, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionLessonSection section : sections) {
            updateSection(course, section, user);
        }
    }

    @Override
    public void removeSections(CmCourseSessionLesson lesson, List<CmCourseSessionLessonSection> sections, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionLessonSection section : sections) {
            removeSection(lesson, section, user);
        }
    }

    @Override
    public void addContent(CmCourseSessionLessonSection section, CmCourseSessionLessonContent content, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        content.setSection(section);

        // prepare metadata
        CmMetadata metadata = new CmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        metadata.setState(CmMetaState.ACTIVE);
        content.setMetadata(metadata);
        session.save(content);
    }

    @Override
    public void updateContent(CmCourseSessionLessonSection section, CmCourseSessionLessonContent content, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        content.setSection(section);

        // prepare metadata
        CmMetadata metadata = content.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        content.setMetadata(metadata);
        session.update(content);
    }

    @Override
    public void removeContent(CmCourseSessionLessonSection section, CmCourseSessionLessonContent content, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        content.setSection(section);

        // prepare metadata
        CmMetadata metadata = content.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        metadata.setState(CmMetaState.INACTIVE);
        content.setMetadata(metadata);
        session.update(content);
    }

    @Override
    public void addContents(CmCourseSessionLessonSection section, List<? extends CmCourseSessionLessonContent> contents, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionLessonContent content : contents) {
            addContent(section, content, user);
        }
    }

    @Override
    public void updateContents(CmCourseSessionLessonSection section, List<? extends CmCourseSessionLessonContent> contents, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionLessonContent content : contents) {
            updateContent(section, content, user);
        }
    }

    @Override
    public void removeContents(CmCourseSessionLessonSection section, List<? extends CmCourseSessionLessonContent> contents, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionLessonContent content : contents) {
            removeContent(section, content, user);
        }
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}
