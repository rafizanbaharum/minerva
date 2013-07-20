package net.canang.minerva.core.dao.impl;

import net.canang.minerva.core.dao.CmActorDao;
import net.canang.minerva.core.dao.CmStudentDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.CmMetaState;
import net.canang.minerva.core.model.CmStudent;
import net.canang.minerva.core.model.impl.CmStudentImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/20/13
 */
@Repository("studentDao")
public class CmStudentDaoImpl extends DaoSupport<Long, CmStudent, CmStudentImpl> implements CmStudentDao {

    @Autowired
    private CmActorDao actorDao;

    @Override
    public CmStudent findById(Long id) {
        return (CmStudent) actorDao.findById(id);
    }

    @Override
    public CmStudent findByMatrixNo(String matrixNo) {
        return (CmStudent) actorDao.findByIdentityNo(matrixNo);
    }

    @Override
    public List<CmStudent> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmStudent a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<CmStudent> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from CmStudent a where " +
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
        Query query = session.createQuery("select count(a) from CmStudent a where " +
                "a.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from CmStudent a where " +
                "(a.name like upper(:filter) " +
                "or upper(a.identityNo) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
}
