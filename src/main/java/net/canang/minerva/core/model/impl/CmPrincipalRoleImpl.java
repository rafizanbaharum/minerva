package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmPrincipal;
import net.canang.minerva.core.model.CmPrincipalRole;
import net.canang.minerva.core.model.CmRoleType;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
@Table(name = "CM_PCPL_ROLE")
@Entity(name = "CmPrincipalRole")
public class CmPrincipalRoleImpl implements CmPrincipalRole {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_PCPL")
    @SequenceGenerator(name = "SEQ_CM_PCPL", sequenceName = "SEQ_CM_PCPL", allocationSize = 1)
    private Long id;

    @Column(name = "ROLE_TYPE")
    private CmRoleType roleType;

    @OneToOne(targetEntity = CmPrincipalImpl.class)
    @JoinColumn(name = "PRINCIPAL_ID")
    private CmPrincipal principal;

    @Embedded
    private CmMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CmRoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(CmRoleType roleType) {
        this.roleType = roleType;
    }

    public CmPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(CmPrincipal principal) {
        this.principal = principal;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
