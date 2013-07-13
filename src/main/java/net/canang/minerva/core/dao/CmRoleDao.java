package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmPrincipal;
import net.canang.minerva.core.model.CmRoleType;
import net.canang.minerva.core.model.CmUser;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
public interface CmRoleDao {

    void grant(CmPrincipal principal, CmRoleType roleType, CmUser user);

    void grant(CmPrincipal principal, CmRoleType[] roleTypes, CmUser user);

    void revoke(CmPrincipal principal, CmRoleType roleType, CmUser user);

    void revoke(CmPrincipal principal, CmRoleType[] roleTypes, CmUser user);

    void revokeAll(CmPrincipal principal, CmUser user);

    void overwrite(CmPrincipal principal, CmRoleType roleType, CmUser user);

    void overwrite(CmPrincipal principal, CmRoleType[] roleTypes, CmUser user);

    void update(CmPrincipal principal, CmRoleType[] roleTypes, CmUser user);

}
