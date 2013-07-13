package net.canang.minerva.core.dao.impl;

import net.canang.minerva.core.RecursiveGroupException;
import net.canang.minerva.core.dao.CmPrincipalDao;
import net.canang.minerva.core.dao.CmRoleDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.CmMetaState;
import net.canang.minerva.core.model.CmPrincipal;
import net.canang.minerva.core.model.CmPrincipalType;
import net.canang.minerva.core.model.impl.CmPrincipalImpl;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
@Repository("principalDao")
public class CmPrincipalDaoImpl extends DaoSupport<Long, CmPrincipal, CmPrincipalImpl> implements CmPrincipalDao {

    // logger
    private static final Logger log = Logger.getLogger(CmPrincipalDaoImpl.class);

    private CmRoleDao roleDao;

    private boolean allowRecursiveGroup = false;

    private Set<String> groupName = null;

    //principal

    @Override
    public List<CmPrincipal> findAllPrincipals() {
        Session session = sessionFactory.getCurrentSession();
        List<CmPrincipal> results = new ArrayList<CmPrincipal>();
        Query query = session.createQuery("select p from CmUser p where p.metadata.state = :state order by p.name");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        results.addAll((List<CmPrincipal>) query.list());

        Query queryGroup = session.createQuery("select p from CmGroup p where p.metadata.state = :state order by p.name ");
        queryGroup.setInteger("state", CmMetaState.ACTIVE.ordinal());
        results.addAll((List<CmPrincipal>) queryGroup.list());

        return results;
    }

    @Override
    public List<CmPrincipal> findPrincipals(String filter) {
        Session session = sessionFactory.getCurrentSession();
        List<CmPrincipal> results = new ArrayList<CmPrincipal>();
        Query query = session.createQuery("select p from CmPrincipal p where p.metadata.state = :state and p.name like :filter order by p.name");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        results.addAll((List<CmPrincipal>) query.list());
        return results;
    }

    @Override
    public List<CmPrincipal> findPrincipals(String filter, CmPrincipalType type) {
        Session session = sessionFactory.getCurrentSession();
        List<CmPrincipal> results = new ArrayList<CmPrincipal>();
        Query query = session.createQuery("select p from CmPrincipal p where " +
                "p.metadata.state = :state " +
                "and p.name like :filter " +
                "and p.principalType = :principalType " +
                "order by p.name");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("principalType", type.ordinal());
        results.addAll((List<CmPrincipal>) query.list());
        return results;
    }

    /**
     * find principal
     *
     * @param offset offset
     * @param limit  limit
     * @return list of principals
     */
    @Override
    public List<CmPrincipal> findPrincipals(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from CmPrincipal p");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<CmPrincipal>) query.list();
    }

    public Set<GrantedAuthority> loadEffectiveAuthorities(CmPrincipal principal) throws RecursiveGroupException {
        return new HashSet<GrantedAuthority>(); // todo
    }

    @Override
    public CmPrincipal findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        log.debug("Searching for principal " + name);
        Query query = session.createQuery("select p from CmPrincipal p where p.name = :name");
        query.setString("name", name);
        return (CmPrincipal) query.uniqueResult();
    }
}
