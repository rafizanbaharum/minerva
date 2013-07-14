package net.canang.minerva.core.dao.impl;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */

import net.canang.minerva.core.dao.CmCourseQuizDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.*;
import net.canang.minerva.core.model.impl.CmCourseQuizImpl;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 */
@Repository("courseQuizDao")
public class CmCourseQuizDaoImpl extends DaoSupport<Long, CmCourseQuiz, CmCourseQuizImpl> implements CmCourseQuizDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmCourseQuiz findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourseQuiz) session.get(CmCourseQuizImpl.class, id);
    }

    @Override
    public CmCourseQuiz findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseQuiz a where a.code = :code");
        query.setString("code", code);
        return (CmCourseQuiz) query.uniqueResult();
    }

    @Override
    public List<CmCourseQuiz> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseQuiz a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmCourseQuiz> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseQuiz a where " +
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
        Query query = session.createQuery("select count(a) from CmCourseQuiz a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmCourseQuiz a where " +
                "(a.code like upper(:filter) " +
                "or upper(a.description) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public void addSection(CmCourseQuiz quiz, CmCourseQuizSection section, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        section.setQuiz(quiz);

        // prepare metadata
        CmMetadata metadata = new CmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        metadata.setState(CmMetaState.ACTIVE);
        section.setMetadata(metadata);
        session.save(section);
    }

    @Override
    public void updateSection(CmCourseQuiz quiz, CmCourseQuizSection section, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        section.setQuiz(quiz);

        // prepare metadata
        CmMetadata metadata = section.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        section.setMetadata(metadata);
        session.update(section);
    }

    @Override
    public void removeSection(CmCourseQuiz quiz, CmCourseQuizSection section, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        section.setQuiz(quiz);

        // prepare metadata
        CmMetadata metadata = section.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        metadata.setState(CmMetaState.INACTIVE);
        section.setMetadata(metadata);
        session.update(section);
    }

    @Override
    public void addSections(CmCourseQuiz quiz, List<CmCourseQuizSection> sections, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseQuizSection section : sections) {
            addSection(quiz, section, user);
        }
    }

    @Override
    public void updateSections(CmCourseQuiz course, List<CmCourseQuizSection> sections, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseQuizSection section : sections) {
            updateSection(course, section, user);
        }
    }

    @Override
    public void removeSections(CmCourseQuiz quiz, List<CmCourseQuizSection> sections, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseQuizSection section : sections) {
            removeSection(quiz, section, user);
        }
    }

    @Override
    public void addQuestion(CmCourseQuizSection section, CmCourseQuestion question, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        question.setSection(section);

        // prepare metadata
        CmMetadata metadata = new CmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        metadata.setState(CmMetaState.ACTIVE);
        question.setMetadata(metadata);
        session.save(question);
    }

    @Override
    public void updateQuestion(CmCourseQuizSection section, CmCourseQuestion question, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        question.setSection(section);

        // prepare metadata
        CmMetadata metadata = question.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        question.setMetadata(metadata);
        session.update(question);
    }

    @Override
    public void removeQuestion(CmCourseQuizSection section, CmCourseQuestion question, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        question.setSection(section);

        // prepare metadata
        CmMetadata metadata = question.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        metadata.setState(CmMetaState.INACTIVE);
        question.setMetadata(metadata);
        session.update(question);
    }

    @Override
    public void addQuestions(CmCourseQuizSection section, List<CmCourseQuestion> questions, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseQuestion question : questions) {
            addQuestion(section, question, user);
        }
    }

    @Override
    public void updateQuestions(CmCourseQuizSection section, List<CmCourseQuestion> questions, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseQuestion question : questions) {
            updateQuestion(section, question, user);
        }
    }

    @Override
    public void removeQuestions(CmCourseQuizSection section, List<CmCourseQuestion> questions, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseQuestion question : questions) {
            removeQuestion(section, question, user);
        }
    }


    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}
