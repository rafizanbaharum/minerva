package net.canang.minerva.core;

import net.canang.minerva.core.dao.CmCourseSessionDao;
import net.canang.minerva.core.dao.CmUserDao;
import net.canang.minerva.core.model.CmPrincipalType;
import net.canang.minerva.core.model.CmUser;
import net.canang.minerva.core.model.impl.CmUserImpl;
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
@ContextConfiguration(classes = {CmTestConfig.class})
public class CmUserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(CmUserDaoTest.class);

    @Autowired
    private CmCourseSessionDao courseSessionDao;

    @Autowired
    private CmUserDao userDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() {
        log.debug("logging in user");
        log.debug(passwordEncoder.encodePassword("abc123", null));
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("root", "abc123");

        Authentication authed = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }


    @Test
    @Rollback(value = false)
    public void createUser() {
        CmUser root = userDao.findByUsername("root");
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
