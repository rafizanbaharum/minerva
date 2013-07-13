package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmGroup;
import net.canang.minerva.core.model.CmGroupMember;
import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmPrincipal;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
@Table(name = "CM_GROP_MMBR")
@Entity(name = "CmGroupMember")
public class CmGroupMemberImpl implements CmGroupMember {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_GROP_MMBR")
    @SequenceGenerator(name = "SEQ_CM_GROP_MMBR", sequenceName = "SEQ_CM_GROP_MMBR", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = CmGroupImpl.class)
    @JoinColumn(name = "GROUP_ID")
    private CmGroup group;

    @OneToOne(targetEntity = CmPrincipalImpl.class)
    @JoinColumn(name = "MEMBER_ID")
    private CmPrincipal member;

    @Embedded
    private CmMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CmGroup getGroup() {
        return group;
    }

    public void setGroup(CmGroup group) {
        this.group = group;
    }

    public CmPrincipal getMember() {
        return member;
    }

    public void setMember(CmPrincipal member) {
        this.member = member;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
