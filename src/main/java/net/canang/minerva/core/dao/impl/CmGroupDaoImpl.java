package net.canang.minerva.core.dao.impl;

import net.canang.minerva.core.LockedGroupException;
import net.canang.minerva.core.RecursiveGroupException;
import net.canang.minerva.core.dao.CmGroupDao;
import net.canang.minerva.core.dao.DaoSupport;
import net.canang.minerva.core.model.*;
import net.canang.minerva.core.model.impl.CmGroupImpl;
import net.canang.minerva.core.model.impl.CmGroupMemberImpl;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
@Repository("groupDao")
public class CmGroupDaoImpl extends DaoSupport<Long, CmGroup, CmGroupImpl> implements CmGroupDao {

    private static final Logger log = Logger.getLogger(CmGroupDaoImpl.class);
    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public CmGroup findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CmGroup) session.get(CmGroupImpl.class, id);
    }

    @Override
    public List<CmGroup> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from CmGroup g order by g.name");
        return (List<CmGroup>) query.list();
    }

    @Override
    public List<String> findAllGroupName() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g.name from CmGroup g");
        return (List<String>) query.list();
    }

    @Override
    public CmGroup findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from CmGroup g where g.name = :name");
        query.setString("name", name);
        return (CmGroup) query.uniqueResult();
    }

    @Override
    public List<CmPrincipal> findMembers(CmGroup group) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.principal from CmGroupMember gm where " +
                "gm.group = :group " +
                "order by gm.principal.name");
        query.setEntity("group", group);
        return (List<CmPrincipal>) query.list();
    }

    /**
     * XXX: ClassCastException issues
     * XXX: select gm.principal wil get you abstract CmPrincipal
     * XXX: not extension classes
     *
     * @param group
     * @param type
     * @return
     */
    @Override
    public List<CmPrincipal> findMembers(CmGroup group, CmPrincipalType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = null;

        String selectGroup = "select g from CmGroup g where " +
                "id in (select gm.principal.id from CmGroupMember gm where " +
                "gm.group = :group " +
                "and gm.principal.principalType = :type )" +
                "order by g.name";
        String selectUser = "select u from CmUser u where " +
                "id in (select gm.principal.id from CmGroupMember gm where " +
                "gm.group = :group " +
                "and gm.principal.principalType = :type )" +
                "order by u.name";
        switch (type) {
            case USER:
                query = session.createQuery(selectUser);
                break;
            case GROUP:
                query = session.createQuery(selectGroup);
                break;
        }
        query.setEntity("group", group);
        query.setInteger("type", type.ordinal());
        return (List<CmPrincipal>) query.list();
    }

    @Override
    public List<CmGroup> findPrincipalGroups(CmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.group from CmGroupMember gm inner join gm.principal where " +
                "gm.principal = :principal");
        query.setEntity("principal", principal);
        return (List<CmGroup>) query.list();
    }

    @Override
    public List<CmPrincipal> findMembers(CmGroup group, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.principal from CmGroupMember gm where " +
                "gm.group = :group " +
                "order by gm.principal.name");
        query.setEntity("group", group);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<CmPrincipal>) query.list();
    }

    @Override
    public List<CmGroup> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from CmGroup g order by g.name");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<CmGroup>) query.list();
    }


    @Override
    public List<CmGroup> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct g from CmGroup g where " +
                "g.name like upper(:filter) " +
                "and g.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<CmGroup>) query.list();
    }

    @Override
    public List<CmGroup> findParentGroup(CmGroup group) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from CmGroup g inner join g.groupMembers m where m.principal = :group");
        query.setEntity("group", group);
        return (List<CmGroup>) query.list();
    }

    @Override
    public Set<CmGroup> findHierarchicalGroupAsNative(CmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        String sqlQuery = "SELECT /*+ USE_NL(U) IGNORE_OPTIM_EMBEDDED_HINTS */ CONNECT_BY_ROOT p.id parent " +
                "FROM fs_principal p, fs_group g, fs_group_member m, fs_principal u " +
                "WHERE p.id = g.id " +
                "AND m.group_id = g.id " +
                "AND m.principal_id = u.id " +
                "and u.name = '" + principal.getName() + "' " +
                "connect by prior m.principal_id = m.group_id";
        sqlQuery = "SELECT DISTINCT parent FROM ( " + sqlQuery + ")";
        SQLQuery query = session.createSQLQuery(sqlQuery);
        query.addScalar("parent", LongType.INSTANCE);
        List<Long> results = (List<Long>) query.list();
        Set<CmGroup> groups = new HashSet<CmGroup>();
        for (Long result : results) {
            groups.add(findById(result));
        }
        return groups;
    }

    @Override
    public List<String> findHierarchicalGroupRoleAsNative(CmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        String sqlQuery = "SELECT /*+ USE_HASH(U,M,G) ORDERED IGNORE_OPTIM_EMBEDDED_HINTS */ 'X' \n" +
                "FROM fs_principal p, " +
                "fs_group g, " +
                "fs_group_member m, " +
                "fs_principal u " +
                "WHERE p.id = g.id " +
                "AND m.group_id = g.id " +
                "AND m.principal_id = u.id " +
                "and u.name = '" + principal.getName() + "' " +
                "AND CONNECT_BY_ROOT p.id = FS_GROUP_ROLE.group_id \n" +
                "connect by prior m.principal_id = m.group_id";
        sqlQuery = "select role from fs_group_role where exists ( " + sqlQuery + " )";
        SQLQuery query = session.createSQLQuery(sqlQuery);
        query.addScalar("role", StringType.INSTANCE);
        return (List<String>) query.list();
    }

    @Override
    public Set<CmGroup> findHierarchicalGroupAsView(CmPrincipal principal) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(g) from CmGroup g where " +
                "g.metadata.state = :state");
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(g) from CmGroup g where " +
                "g.name like upper(:filter) " +
                "and g.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isMemberOf(CmGroup group, CmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(g) from CmGroupMember g where " +
                "g.group = :group " +
                "and g.principal = :principal");
        query.setEntity("group", group);
        query.setEntity("principal", principal);
        return ((Long) query.uniqueResult()).intValue() >= 1;
    }

    @Override
    public CmGroupMember findGroupMember(CmGroup group, CmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from CmGroupMember g where " +
                "g.group = :group " +
                "and g.principal = :principal");
        query.setEntity("group", group);
        query.setEntity("principal", principal);
        return (CmGroupMember) query.uniqueResult();
    }

// =============================================================================
    // CRUD METHODS
    // =============================================================================

    @Override
    public void addMember(CmGroup group, CmPrincipal member, CmUser user) throws RecursiveGroupException, LockedGroupException {

        // validate
        Validate.notNull(group, "Group should not be null");
        Validate.notNull(member, "Group member should not be null");

        // check locked group
        if (group.isLocked()) {
            log.error("Group is locked");
            throw new LockedGroupException("Locked group");
        }

        // check recursive add
        if (member instanceof CmGroup) {
            if (isInRecursive(group, (CmGroup) member))
                throw new RecursiveGroupException("Recursive user group detected");
        }

        // session
        Session session = sessionFactory.getCurrentSession();

        // populate
        CmGroupMember groupMember = new CmGroupMemberImpl();
        groupMember.setGroup(group);
        groupMember.setMember(member);

        // prepare metadata
        CmMetadata metadata = new CmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        groupMember.setMetadata(metadata);
        session.save(groupMember);
    }

    @Override
    public void addMembers(CmGroup group, List<CmPrincipal> principals, CmUser user) throws RecursiveGroupException, LockedGroupException {
        List<CmPrincipal> principalGroups = findMembers(group);
        List<CmPrincipal> newPrincipals = new ArrayList<CmPrincipal>();

        for (CmPrincipal principal : principals) {
            newPrincipals.add(principal);
        }

        for (CmPrincipal principalGroup : principalGroups) {
            if (!newPrincipals.contains(principalGroup)) {
                removeMember(group, principalGroup);
            }
        }

        for (CmPrincipal newGroup : newPrincipals) {
            if (!principalGroups.contains(newGroup)) {
                addMember(group, newGroup, user);
            }
        }
    }

    @Override
    public void removeMember(CmGroup group, CmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from CmGroupMember g where g.group = :group and g.principal = :principal");
        query.setEntity("group", group);
        query.setEntity("principal", principal);
        CmGroupMember groupMember = (CmGroupMember) query.uniqueResult();
        session.delete(groupMember);
    }

    private boolean isInRecursive(CmGroup parent, CmGroup child) {
        Set<CmGroup> hierarchicalGroup = findHierarchicalGroupAsNative(parent);
        return !hierarchicalGroup.add(child);
    }

}
