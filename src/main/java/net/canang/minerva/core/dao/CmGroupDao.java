package net.canang.minerva.core.dao;

import net.canang.minerva.core.LockedGroupException;
import net.canang.minerva.core.RecursiveGroupException;
import net.canang.minerva.core.model.*;

import java.util.List;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmGroupDao {

    // finders

    CmGroup findById(Long id);

    CmGroup findByName(String name);

    List<CmGroup> findAll();

    List<String> findAllGroupName();

    List<CmPrincipal> findMembers(CmGroup group);

    List<CmPrincipal> findMembers(CmGroup group, CmPrincipalType type);

    List<CmGroup> findPrincipalGroups(CmPrincipal principal);

    List<CmPrincipal> findMembers(CmGroup group, Integer offset, Integer limit);

    List<CmGroup> find(Integer offset, Integer limit);

    List<CmGroup> find(String filter, Integer offset, Integer limit);

    List<CmGroup> findParentGroup(CmGroup group);

    Set<CmGroup> findHierarchicalGroupAsNative(CmPrincipal principal);

    List<String> findHierarchicalGroupRoleAsNative(CmPrincipal principal);

    Set<CmGroup> findHierarchicalGroupAsView(CmPrincipal principal);

    CmGroupMember findGroupMember(CmGroup group, CmPrincipal principal);

    Integer count();

    Integer count(String filter);

    boolean isMemberOf(CmGroup group, CmPrincipal principal);

    void save(CmGroup group, CmUser user);

    void update(CmGroup group, CmUser user);

    void deactivate(CmGroup group, CmUser user);

    void remove(CmGroup group, CmUser user) throws LockedGroupException;

    void addMember(CmGroup group, CmPrincipal principal, CmUser user) throws RecursiveGroupException, LockedGroupException;

    void addMembers(CmGroup group, List<CmPrincipal> principals, CmUser user) throws RecursiveGroupException, LockedGroupException;

    void removeMember(CmGroup group, CmPrincipal principal) throws LockedGroupException;

}
