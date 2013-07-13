package net.canang.minerva.biz.integration;

import net.canang.minerva.core.model.CmUser;
import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
@Component("userDetails")
@Transactional
public class CmUserDetails implements UserDetails {

    private static final Logger log = Logger.getLogger(CmUserDetails.class);

    private CmUser user;
    private Set<GrantedAuthority> grantedAuthorities;

    public CmUserDetails() {
    }

    public CmUserDetails(CmUser user, Set<GrantedAuthority> grantedAuthorities) {
        this.user = user;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getName();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return user.isLocked();
    }

    public void setUser(CmUser user) {
        this.user = user;
    }

    public CmUser getUser() {
        return user;
    }

    public String getRealname() {
        return user.getRealname();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public Long getId() {
        return user.getId();
    }
}
