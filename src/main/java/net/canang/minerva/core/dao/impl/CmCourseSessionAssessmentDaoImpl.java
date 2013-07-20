package net.canang.minerva.core.dao.impl;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */

import net.canang.minerva.core.dao.CmCourseSessionAssessmentDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.CmCourseSessionAssessment;
import net.canang.minerva.core.model.impl.CmCourseSessionAssessmentImpl;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository("courseSessionAssessmentDao")
public class CmCourseSessionAssessmentDaoImpl extends DaoSupport<Long, CmCourseSessionAssessment, CmCourseSessionAssessmentImpl> implements CmCourseSessionAssessmentDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmCourseSessionAssessment findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmCourseSessionAssessment) session.get(CmCourseSessionAssessmentImpl.class, id);
    }
}
