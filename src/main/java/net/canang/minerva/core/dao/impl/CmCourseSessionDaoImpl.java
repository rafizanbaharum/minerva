package net.canang.minerva.core.dao.impl;

import net.canang.minerva.core.dao.CmCourseSessionDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.CmCourseSession;
import net.canang.minerva.core.model.CmCourseSessionImpl;
import net.canang.minerva.core.model.CmDepartment;
import net.canang.minerva.core.model.CmSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@SuppressWarnings({"unchecked"})
public class CmCourseSessionDaoImpl extends DaoSupport<Long, CmCourseSession, CmCourseSessionImpl> implements CmCourseSessionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CmCourseSession> getCourses(CmSession session) {
        Session sn = sessionFactory.getCurrentSession();
        Query query = sn.createQuery("select cs from CmCourseSession cs where " +
                "cs.session = :session");
        query.setEntity("session", session);
        return (List<CmCourseSession>) query.list();
    }

    @Override
    public List<CmCourseSession> getCourses(CmSession session, CmDepartment department) {
        Session sn = sessionFactory.getCurrentSession();
        Query query = sn.createQuery("select cs from CmCourseSession cs where " +
                "cs.session = :session");
        query.setEntity("session", session);
        query.setEntity("department", department);
        return (List<CmCourseSession>) query.list();
    }
}
