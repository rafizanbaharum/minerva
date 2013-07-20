package net.canang.minerva.core;

import net.canang.minerva.core.config.CmCoreConfig;
import net.canang.minerva.core.dao.CmUserDao;
import net.canang.minerva.core.model.CmPrincipalType;
import net.canang.minerva.core.model.CmUser;
import net.canang.minerva.core.model.impl.CmUserImpl;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CmCoreConfig.class})
public class CmUserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(CmUserDaoTest.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CmUserDao userDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private CmUser root;

    @Before
    public void setUp() {

        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("insert into CM_PCPL (ID, NAME, PRINCIPAL_TYPE, LOCKED, M_ST, C_ID, C_TS) values (1, 'root', 0, 1, 1, 0, TIMESTAMP '2013-01-01 00:00:00')");
        query.executeUpdate();
        query = session.createSQLQuery("insert into CM_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID) values (1, 'System Root', '6367c48dd193d56ea7b0baad25b19455e529f5ee', 'rafizan.baharum@gmail.com', null)");
        query.executeUpdate();
        query = session.createSQLQuery("insert into CM_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(1, 0, 1, 1, 1, SYSTIMESTAMP)");
        query.executeUpdate();

        log.debug("logging in user");
        log.debug(passwordEncoder.encodePassword("abc123", null));
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("root", "abc123");
        Authentication authed = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }


    @Test
    @Rollback(value = true)
    public void findUser() {
        root = userDao.findByUsername("root");
        Assert.assertNotNull(root);
    }


    @Test
    @Rollback(value = true)
    public void createUser() {
        CmUser newUser = new CmUserImpl();
        newUser.setUsername("newuser");
        newUser.setRealname("New User");
        newUser.setEmail("test");
        newUser.setPassword(passwordEncoder.encodePassword("abc123", null));
        newUser.setLocked(false);
        newUser.setPrincipalType(CmPrincipalType.USER);
        userDao.save(newUser, root);
        CmUser saved = userDao.findByUsername("newuser");
        Assert.assertNotNull(saved);
    }

}
