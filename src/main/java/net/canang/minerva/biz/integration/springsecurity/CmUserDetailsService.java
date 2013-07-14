package net.canang.minerva.biz.integration.springsecurity;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */

import net.canang.minerva.core.RecursiveGroupException;
import net.canang.minerva.core.dao.CmPrincipalDao;
import net.canang.minerva.core.model.CmMetaState;
import net.canang.minerva.core.model.CmPrincipalRole;
import net.canang.minerva.core.model.CmUser;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 */
@Service("userDetailService")
@Transactional
public class CmUserDetailsService implements UserDetailsService {

    private static final Logger log = Logger.getLogger(CmUserDetailsService.class);

    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    private CmPrincipalDao principalDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException, DataAccessException {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from CmUser u where u.name = :username and u.metadata.state = :state");
        query.setString("username", s);
        query.setInteger("state", CmMetaState.ACTIVE.ordinal());
        CmUser user = (CmUser) query.uniqueResult();
        if (user == null)
            throw new UsernameNotFoundException("No such user");
        return new CmUserDetails(user, loadGrantedAuthoritiesFor(user));
    }

    private Set<GrantedAuthority> loadGrantedAuthoritiesFor(CmUser user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        try {
            //load all roles which ties to user
            for (CmPrincipalRole role : user.getRoles()) {
                grantedAuthorities.add(new GrantedAuthorityImpl(role.getRoleType().name()));
            }
            log.info("load auth for " + user.getName() + "#" + user.getId());
            grantedAuthorities.addAll(principalDao.loadEffectiveAuthorities(user));
        } catch (RecursiveGroupException e) {
            log.error(e.getMessage());
            grantedAuthorities.clear();
        }
        return grantedAuthorities;
    }
}
