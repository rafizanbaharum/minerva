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

    @Override
    public void addLesson(CmCourseModule module, CmCourseLesson lesson, CmUser user) {
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

    @Override
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

    @Override
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

    @Override
    public void addLessons(CmCourseModule module, List<CmCourseLesson> lessons, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseLesson lesson : lessons) {
            addLesson(module, lesson, user);
        }
    }

    @Override
    public void updateLessons(CmCourseModule course, List<CmCourseLesson> lessons, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseLesson lesson : lessons) {
            updateLesson(course, lesson, user);
        }
    }

    @Override
    public void removeLessons(CmCourseModule module, List<CmCourseLesson> lessons, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseLesson lesson : lessons) {
            removeLesson(module, lesson, user);
        }
    }

    @Override
    public void addQuiz(CmCourseModule module, CmCourseQuiz quiz, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        quiz.setModule(module);

        // prepare metadata
        CmMetadata metadata = new CmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        metadata.setState(CmMetaState.ACTIVE);
        quiz.setMetadata(metadata);
        session.save(quiz);
    }

    @Override
    public void updateQuiz(CmCourseModule module, CmCourseQuiz quiz, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        quiz.setModule(module);

        // prepare metadata
        CmMetadata metadata = quiz.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        quiz.setMetadata(metadata);
        session.update(quiz);
    }

    @Override
    public void removeQuiz(CmCourseModule module, CmCourseQuiz quiz, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        quiz.setModule(module);

        // prepare metadata
        CmMetadata metadata = quiz.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        metadata.setState(CmMetaState.INACTIVE);
        quiz.setMetadata(metadata);
        session.update(quiz);
    }

    @Override
    public void addQuizzes(CmCourseModule module, List<CmCourseQuiz> quizzes, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseQuiz quiz : quizzes) {
            addQuiz(module, quiz, user);
        }
    }

    @Override
    public void updateQuizzes(CmCourseModule course, List<CmCourseQuiz> quizzes, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseQuiz quiz : quizzes) {
            updateQuiz(course, quiz, user);
        }
    }

    @Override
    public void removeQuizzes(CmCourseModule module, List<CmCourseQuiz> quizzes, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseQuiz quiz : quizzes) {
            removeQuiz(module, quiz, user);
        }
    }


    @Override
    public void addContent(CmCourseLesson lesson, CmCourseContent content, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        content.setLesson(lesson);

        // prepare metadata
        CmMetadata metadata = new CmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        metadata.setState(CmMetaState.ACTIVE);
        content.setMetadata(metadata);
        session.save(content);
    }

    @Override
    public void updateContent(CmCourseLesson lesson, CmCourseContent content, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        content.setLesson(lesson);

        // prepare metadata
        CmMetadata metadata = content.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        content.setMetadata(metadata);
        session.update(content);
    }

    @Override
    public void removeContent(CmCourseLesson lesson, CmCourseContent content, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        content.setLesson(lesson);

        // prepare metadata
        CmMetadata metadata = content.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        metadata.setState(CmMetaState.INACTIVE);
        content.setMetadata(metadata);
        session.update(content);
    }

    @Override
    public void addContents(CmCourseLesson lesson, List<CmCourseContent> contents, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseContent content : contents) {
            addContent(lesson, content, user);
        }
    }

    @Override
    public void updateContents(CmCourseLesson course, List<CmCourseContent> contents, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseContent content : contents) {
            updateContent(course, content, user);
        }
    }

    @Override
    public void removeContents(CmCourseLesson lesson, List<CmCourseContent> contents, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseContent content : contents) {
            removeContent(lesson, content, user);
        }
    }


    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}
