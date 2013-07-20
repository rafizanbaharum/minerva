package net.canang.minerva.core.dao.impl;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */

import net.canang.minerva.core.dao.CmCourseModuleDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.*;
import net.canang.minerva.core.model.impl.CmCourseAssessmentImpl;
import net.canang.minerva.core.model.impl.CmCourseLessonImpl;
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
    public CmCourseModule findByOrder(CmCourse course, Integer order) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseModule a where " +
                "a.course = :course " +
                "and a.order = :order");
        query.setEntity("course", course);
        query.setInteger("order", order);
        return (CmCourseModule) query.uniqueResult();

    }

    @Override
    public CmCourseAssessment findAssessmentById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourseAssessment) session.get(CmCourseAssessmentImpl.class, id);
    }

    @Override
    public CmCourseLesson findLessonById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourseLesson) session.get(CmCourseLessonImpl.class, id);
    }

    @Override
    public List<CmCourseModule> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseModule a where " +
                "a.metadata.state = :state " +
                "order by a.order");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmCourseModule> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmCourseModule a where " +
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
    public void addAssessment(CmCourseModule module, CmCourseAssessment assessment, CmUser user) {
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
    public void updateAssessment(CmCourseModule module, CmCourseAssessment assessment, CmUser user) {
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
    public void removeAssessment(CmCourseModule module, CmCourseAssessment assessment, CmUser user) {
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
    public void addAssessments(CmCourseModule module, List<? extends CmCourseAssessment> assessments, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseAssessment assessment : assessments) {
            addAssessment(module, assessment, user);
        }
    }

    @Override
    public void updateAssessments(CmCourseModule course, List<? extends CmCourseAssessment> assessments, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseAssessment assessment : assessments) {
            updateAssessment(course, assessment, user);
        }
    }

    @Override
    public void removeAssessments(CmCourseModule module, List<? extends CmCourseAssessment> assessments, CmUser user) {
        Validate.notNull(user, "User cannot be null");
        for (CmCourseAssessment assessment : assessments) {
            removeAssessment(module, assessment, user);
        }
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}
