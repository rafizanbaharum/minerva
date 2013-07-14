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
public class CmCourseAssetTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(CmCourseAssetTest.class);

    @Autowired
    private CmUserDao userDao;

    @Autowired
    private CmFacultyDao facultyDao;

    @Autowired
    private CmDepartmentDao departmentDao;

    @Autowired
    private CmCourseDao courseDao;

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
    public void testContent() {
        CmFaculty faculty = new CmFacultyImpl();
        faculty.setCode("CoE");
        faculty.setAlias("CoE");
        faculty.setDescription("College of Engineer");
        facultyDao.save(faculty, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(faculty);

        log.debug("department");
        CmDepartment department = new CmDepartmentImpl();
        department.setCode("CS");
        department.setAlias("CS");
        department.setDescription("Department of Computer Science");
        departmentDao.save(department, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(department);

        log.debug("course");
        CmCourse course = new CmCourseImpl();
        course.setName("Introduction to Android");
        course.setDescription("Introduction to Android mobile programmming");
        course.setKeywords("Android, Introduction, Java, Dalvik, Mobile");
        course.setDifficulty(CmDifficulty.EASY);
        course.setInteractivityLevel(CmInteractivityLevel.A);
        course.setInteractivityType(CmInteractivityType.A);
        course.setDepartment(department);
        courseDao.save(course, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(course);


        CmCourseAsset asset1 = new CmCourseAssetImpl();
        asset1.setName("asset1");
        asset1.setTitle("asset1");
        asset1.setDescription("desc");
        asset1.setKeywords("keywods");
        asset1.setPath("path");
        courseDao.addAsset(course, asset1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(asset1);

        CmCourseAsset asset2 = new CmCourseAssetImpl();
        asset2.setName("asset2");
        asset2.setTitle("asset2");
        asset2.setDescription("desc");
        asset2.setKeywords("keywods");
        asset2.setPath("path");
        courseDao.addAsset(course, asset2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(asset2);

    }
}
