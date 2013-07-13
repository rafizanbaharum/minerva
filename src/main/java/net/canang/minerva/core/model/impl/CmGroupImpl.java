package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmGroup;
import net.canang.minerva.core.model.CmGroupMember;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_GROP")
@Entity(name = "CmGroup")
public class CmGroupImpl extends CmPrincipalImpl implements CmGroup {

    @OneToMany(targetEntity = CmGroupMemberImpl.class, mappedBy = "group")
    Set<CmGroupMember> members;

    public Set<CmGroupMember> getMembers() {
        return members;
    }

    public void setMembers(Set<CmGroupMember> members) {
        this.members = members;
    }
}
