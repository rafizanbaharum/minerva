package net.canang.minerva.core.dao.impl;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */

import net.canang.minerva.core.dao.CmCourseAssessmentDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.CmCourseAssessment;
import net.canang.minerva.core.model.impl.CmCourseAssessmentImpl;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository("courseAssessmentDao")
public class CmCourseAssessmentDaoImpl extends DaoSupport<Long, CmCourseAssessment, CmCourseAssessmentImpl> implements CmCourseAssessmentDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmCourseAssessment findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourseAssessment) session.get(CmCourseAssessmentImpl.class, id);
    }
}
