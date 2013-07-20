package net.canang.minerva.core;

import net.canang.minerva.core.config.CmCoreConfig;
import net.canang.minerva.core.dao.*;
import net.canang.minerva.core.model.*;
import net.canang.minerva.core.model.impl.*;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
public class CmCourseEnrollmentDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(CmCourseEnrollmentDaoTest.class);

    @Autowired
    private CmUserDao userDao;

    @Autowired
    private CmStudentDao studentDao;

    @Autowired
    private CmCourseSessionDao courseDao;

    @Autowired
    private CmCourseEnrollmentDao enrollmentDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    private CmUser root;

    @Before
    public void setUp() {
        log.debug("logging in user");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("root", "abc123");
        Authentication authed = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authed);
        root = userDao.findByUsername("root");
    }

    @Test
    @Rollback(value = false)
    public void enrollStudent() {
        CmCourseSession course = courseDao.findByCode("CS101");
        CmStudent student = studentDao.findByMatrixNo("12345678");
        CmCourseEnrollment enrollment = new CmCourseEnrollmentImpl();
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        enrollmentDao.save(enrollment, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(course);
    }
}
