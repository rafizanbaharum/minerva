package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmActor;
import net.canang.minerva.core.model.CmActorType;
import net.canang.minerva.core.model.CmMetadata;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_ACTR")
@Entity(name = "CmActor")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CmActorImpl implements CmActor {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_FS_ACTOR")
    @SequenceGenerator(name = "SEQ_FS_ACTOR", sequenceName = "SEQ_FS_ACTOR", allocationSize = 1)
    private Long id;

    @Column(name = "IDENTITY_NO")
    private String identityNo;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS1")
    private String address1;

    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "ADDRESS3")
    private String address3;

    @Column(name = "ADDRESS4")
    private String phone;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "ACTOR_TYPE")
    private CmActorType actorType;

    @Embedded
    private CmMetadata metadata = new CmMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public CmActorType getActorType() {
        return actorType;
    }

    public void setActorType(CmActorType actorType) {
        this.actorType = actorType;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}

