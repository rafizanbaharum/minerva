package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmUser;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_USER")
@Entity(name = "CmUser")
public class CmUserImpl extends CmPrincipalImpl implements CmUser {

    private String realname;
    private String password;
    private String email;


    public String getUsername() {
        return getName();
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

    @Override
    public String toString() {
        return "CmUserImpl{" +
                "name='" + getName() + '\'' +
                "realname='" + realname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
