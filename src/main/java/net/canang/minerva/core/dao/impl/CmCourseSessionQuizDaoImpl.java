package net.canang.minerva.core.dao.impl;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */

import net.canang.minerva.core.dao.CmCourseAssessmentDao;
import net.canang.minerva.core.dao.CmCourseSessionQuizDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.*;
import net.canang.minerva.core.model.impl.CmCourseSessionQuizImpl;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 */
@Repository("courseSessionQuizDao")
public class CmCourseSessionQuizDaoImpl extends DaoSupport<Long, CmCourseSessionQuiz, CmCourseSessionQuizImpl> implements CmCourseSessionQuizDao {

    @Autowired
    private CmCourseAssessmentDao assessmentDao;

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmCourseSessionQuiz findById(Long id) {
        return (CmCourseSessionQuiz) assessmentDao.findById(id);
    }

    @Override
    public CmCourseSessionQuiz findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseSessionQuiz a where a.code = :code");
        query.setString("code", code);
        return (CmCourseSessionQuiz) query.uniqueResult();
    }

    @Override
    public List<CmCourseSessionQuiz> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseSessionQuiz a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmCourseSessionQuiz> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseSessionQuiz a where " +
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
        Query query = session.createQuery("select count(a) from CmCourseSessionQuiz a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmCourseSessionQuiz a where " +
                "(a.code like upper(:filter) " +
                "or upper(a.description) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public void addSection(CmCourseSessionQuiz quiz, CmCourseSessionQuizSection section, CmUser user) {
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
    public void updateSection(CmCourseSessionQuiz quiz, CmCourseSessionQuizSection section, CmUser user) {
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
    public void removeSection(CmCourseSessionQuiz quiz, CmCourseSessionQuizSection section, CmUser user) {
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
    public void addSections(CmCourseSessionQuiz quiz, List<CmCourseSessionQuizSection> sections, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionQuizSection section : sections) {
            addSection(quiz, section, user);
        }
    }

    @Override
    public void updateSections(CmCourseSessionQuiz course, List<CmCourseSessionQuizSection> sections, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionQuizSection section : sections) {
            updateSection(course, section, user);
        }
    }

    @Override
    public void removeSections(CmCourseSessionQuiz quiz, List<CmCourseSessionQuizSection> sections, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionQuizSection section : sections) {
            removeSection(quiz, section, user);
        }
    }

    @Override
    public void addQuestion(CmCourseSessionQuizSection section, CmCourseSessionQuizQuestion question, CmUser user) {
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
    public void updateQuestion(CmCourseSessionQuizSection section, CmCourseSessionQuizQuestion question, CmUser user) {
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
    public void removeQuestion(CmCourseSessionQuizSection section, CmCourseSessionQuizQuestion question, CmUser user) {
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
    public void addQuestions(CmCourseSessionQuizSection section, List<? extends CmCourseSessionQuizQuestion> questions, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionQuizQuestion question : questions) {
            addQuestion(section, question, user);
        }
    }

    @Override
    public void updateQuestions(CmCourseSessionQuizSection section, List<? extends CmCourseSessionQuizQuestion> questions, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionQuizQuestion question : questions) {
            updateQuestion(section, question, user);
        }
    }

    @Override
    public void removeQuestions(CmCourseSessionQuizSection section, List<? extends CmCourseSessionQuizQuestion> questions, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionQuizQuestion question : questions) {
            removeQuestion(section, question, user);
        }
    }


    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}
