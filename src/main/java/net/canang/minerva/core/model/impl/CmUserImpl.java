package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmActor;
import net.canang.minerva.core.model.CmUser;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_USER")
@Entity(name = "CmUser")
public class CmUserImpl extends CmPrincipalImpl implements CmUser {

    @Column(name = "REALNAME")
    private String realname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(targetEntity = CmActorImpl.class)
    @JoinColumn(name = "ACTOR_ID")
    private CmActor actor;

    public String getUsername() {
        return getName();
    }

    public void setUsername(String username) {
        setName(username);
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CmActor getActor() {
        return actor;
    }

    public void setActor(CmActor actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "CmUserImpl{" +
                "name='" + getName() + '\'' +
                "realname='" + realname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
