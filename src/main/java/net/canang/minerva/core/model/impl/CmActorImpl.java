package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmActor;
import net.canang.minerva.core.model.CmActorType;
import net.canang.minerva.core.model.CmMetadata;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_ACTOR")
@Entity(name = "CmActor")
public abstract class CmActorImpl implements CmActor {

    private Long id;
    private String name;
    private String email;
    private String address1;
    private String address2;
    private String address3;
    private String phone;
    private String fax;

    private CmActorType actorType;
    private CmMetadata metadata;

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

