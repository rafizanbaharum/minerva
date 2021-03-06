package net.canang.minerva.core.model;

import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmGroup extends CmPrincipal {

    Set<CmGroupMember> getMembers();

    void setMembers(Set<CmGroupMember> members);

}
