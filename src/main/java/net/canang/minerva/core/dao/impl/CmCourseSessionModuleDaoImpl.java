package net.canang.minerva.core.dao.impl;


import net.canang.minerva.core.dao.CmCourseSessionModuleDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.*;
import net.canang.minerva.core.model.impl.CmCourseSessionAssessmentImpl;
import net.canang.minerva.core.model.impl.CmCourseSessionLessonImpl;
import net.canang.minerva.core.model.impl.CmCourseSessionModuleImpl;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
@Repository("courseSessionModuleDao")
public class CmCourseSessionModuleDaoImpl extends DaoSupport<Long, CmCourseSessionModule, CmCourseSessionModuleImpl> implements CmCourseSessionModuleDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmCourseSessionModule findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourseSessionModule) session.get(CmCourseSessionModuleImpl.class, id);
    }

    @Override
    public CmCourseSessionModule findByOrder(CmCourse course, Integer order) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseSessionModule a where " +
                "a.course = :course " +
                "and a.order = :order");
        query.setEntity("course", course);
        query.setInteger("order", order);
        return (CmCourseSessionModule) query.uniqueResult();

    }

    @Override
    public CmCourseSessionAssessment findAssessmentById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourseSessionAssessment) session.get(CmCourseSessionAssessmentImpl.class, id);
    }

    @Override
    public CmCourseSessionLesson findLessonById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourseSessionLesson) session.get(CmCourseSessionLessonImpl.class, id);
    }

    @Override
    public List<CmCourseSessionModule> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseSessionModule a where " +
                "a.metadata.state = :state " +
                "order by a.order");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmCourseSessionModule> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseSessionModule a where " +
                "(a.title like upper(:filter) " +
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
        Query query = session.createQuery("select count(a) from CmCourseSessionModule a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmCourseSessionModule a where " +
                "(a.code like upper(:filter) " +
                "or upper(a.description) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public void addLesson(CmCourseSessionModule module, CmCourseSessionLesson lesson, CmUser user) {
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
    public void updateLesson(CmCourseSessionModule module, CmCourseSessionLesson lesson, CmUser user) {
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
    public void removeLesson(CmCourseSessionModule module, CmCourseSessionLesson lesson, CmUser user) {
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
    public void addLessons(CmCourseSessionModule module, List<CmCourseSessionLesson> lessons, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionLesson lesson : lessons) {
            addLesson(module, lesson, user);
        }
    }

    @Override
    public void updateLessons(CmCourseSessionModule course, List<CmCourseSessionLesson> lessons, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionLesson lesson : lessons) {
            updateLesson(course, lesson, user);
        }
    }

    @Override
    public void removeLessons(CmCourseSessionModule module, List<CmCourseSessionLesson> lessons, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionLesson lesson : lessons) {
            removeLesson(module, lesson, user);
        }
    }

    @Override
    public void addAssessment(CmCourseSessionModule module, CmCourseSessionAssessment assessment, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        assessment.setModule(module);

        // prepare metadata
        CmMetadata metadata = new CmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        metadata.setState(CmMetaState.ACTIVE);
        assessment.setMetadata(metadata);
        session.save(assessment);
    }

    @Override
    public void updateAssessment(CmCourseSessionModule module, CmCourseSessionAssessment assessment, CmUser user) {
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        assessment.setModule(module);

        // prepare metadata
        CmMetadata metadata = assessment.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        assessment.setMetadata(metadata);
        session.update(assessment);
    }

    @Override
    public void removeAssessment(CmCourseSessionModule module, CmCourseSessionAssessment assessment, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        assessment.setModule(module);

        // prepare metadata
        CmMetadata metadata = assessment.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        metadata.setState(CmMetaState.INACTIVE);
        assessment.setMetadata(metadata);
        session.update(assessment);
    }

    @Override
    public void addAssessments(CmCourseSessionModule module, List<? extends CmCourseSessionAssessment> assessments, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionAssessment assessment : assessments) {
            addAssessment(module, assessment, user);
        }
    }

    @Override
    public void updateAssessments(CmCourseSessionModule course, List<? extends CmCourseSessionAssessment> assessments, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionAssessment assessment : assessments) {
            updateAssessment(course, assessment, user);
        }
    }

    @Override
    public void removeAssessments(CmCourseSessionModule module, List<? extends CmCourseSessionAssessment> assessments, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseSessionAssessment assessment : assessments) {
            removeAssessment(module, assessment, user);
        }
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}
