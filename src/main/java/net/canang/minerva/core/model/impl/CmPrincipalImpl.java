package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmPrincipal;
import net.canang.minerva.core.model.CmPrincipalRole;
import net.canang.minerva.core.model.CmPrincipalType;

import javax.persistence.*;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_PCPL")
@Entity(name = "CmPrincipal")
@Inheritance(strategy = InheritanceType.JOINED)
public class CmPrincipalImpl implements CmPrincipal {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_PCPL")
    @SequenceGenerator(name = "SEQ_CM_PCPL", sequenceName = "SEQ_CM_PCPL", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LOCKED")
    private boolean locked;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "PRINCIPAL_TYPE")
    private CmPrincipalType principalType;

    @OneToMany(targetEntity = CmPrincipalRoleImpl.class, mappedBy = "principal", fetch = FetchType.EAGER)
    private Set<CmPrincipalRole> roles;

    @Embedded
    private CmMetadata metadata = new CmMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public CmPrincipalType getPrincipalType() {
        return principalType;
    }

    public void setPrincipalType(CmPrincipalType principalType) {
        this.principalType = principalType;
    }

    public Set<CmPrincipalRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<CmPrincipalRole> roles) {
        this.roles = roles;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "CmPrincipalImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + locked +
                '}';
    }
}
