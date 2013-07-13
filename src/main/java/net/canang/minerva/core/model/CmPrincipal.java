package net.canang.minerva.core.model;

import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmPrincipal extends CmMetaObject {

    String getName();

    void setName(String name);

    boolean isLocked();

    void setLocked(boolean locked);

    CmPrincipalType getPrincipalType();

    void setPrincipalType(CmPrincipalType principalType);

    Set<CmPrincipalRole> getRoles();

    void setRoles(Set<CmPrincipalRole> roles);

}
