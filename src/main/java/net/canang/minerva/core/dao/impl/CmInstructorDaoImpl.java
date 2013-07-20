package net.canang.minerva.core.dao.impl;

import net.canang.minerva.core.dao.CmActorDao;
import net.canang.minerva.core.dao.CmInstructorDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.CmMetaState;
import net.canang.minerva.core.model.CmInstructor;
import net.canang.minerva.core.model.impl.CmInstructorImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/20/13
 */
@Repository("instructorDao")
public class CmInstructorDaoImpl extends DaoSupport<Long, CmInstructor, CmInstructorImpl> implements CmInstructorDao {

    @Autowired
    private CmActorDao actorDao;

    @Override
    public CmInstructor findById(Long id) {
        return (CmInstructor) actorDao.findById(id);
    }

    @Override
    public CmInstructor findByMatrixNo(String matrixNo) {
        return (CmInstructor) actorDao.findByIdentityNo(matrixNo);
    }

    @Override
    public List<CmInstructor> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmInstructor a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmInstructor> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmInstructor a where " +
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
        Query query = session.createQuery("select count(a) from CmInstructor a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmInstructor a where " +
                "(a.name like upper(:filter) " +
                "or upper(a.identityNo) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
}
