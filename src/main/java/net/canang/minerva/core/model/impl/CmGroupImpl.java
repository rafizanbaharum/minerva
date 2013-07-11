package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmGroup;
import net.canang.minerva.core.model.CmPrincipal;

import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmGroupImpl extends CmPrincipalImpl implements CmGroup {

    Set<CmPrincipal> members;

    public Set<CmPrincipal> getMembers() {
        return members;
    }

    public void setMembers(Set<CmPrincipal> members) {
        this.members = members;
    }
}
