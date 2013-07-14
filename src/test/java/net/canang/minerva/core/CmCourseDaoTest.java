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
public class CmCourseDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(CmCourseDaoTest.class);

    @Autowired
    private CmUserDao userDao;

    @Autowired
    private CmFacultyDao facultyDao;

    @Autowired
    private CmDepartmentDao departmentDao;

    @Autowired
    private CmCourseDao courseDao;

    @Autowired
    private CmCourseModuleDao moduleDao;

    @Autowired
    private CmCourseLessonDao lessonDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private CmUser root;

    @Before
    public void setUp() {
        log.debug("logging in user");
        log.debug(passwordEncoder.encodePassword("abc123", null));
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
        sessionFactory.getCurrentSession().refresh(department);

        // create our module
        createModule1(course);
    }

    private void createModule1(CmCourse course) {

        log.debug("module");
        CmCourseModule module1 = new CmCourseModuleImpl();
        module1.setName("Android Service");
        module1.setTitle("Android Service");
        module1.setDescription("Developing own services and using system services in Android");
        module1.setKeywords("Android, Service, System Service");
        module1.setOrder(1);
        module1.setCourse(course);
        courseDao.addModule(course, module1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(module1);

        log.debug("lesson");
        CmCourseLesson lesson1 = new CmCourseLessonImpl();
        lesson1.setName("Android Services");
        lesson1.setTitle("1. Android Services");
        lesson1.setDescription("Android Services");
        lesson1.setKeywords("Platform, Service, Defining");
        lesson1.setOrder(1);
        lesson1.setInteractivityType(CmInteractivityType.A);
        lesson1.setInteractivityLevel(CmInteractivityLevel.B);
        lesson1.setDifficulty(CmDifficulty.EASY);
        moduleDao.addLesson(module1, lesson1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(lesson1);

        log.debug("content1");
        CmCourseContent content1_1 = new CmCourseContentImpl();
        content1_1.setTitle("1.1 Title");
        content1_1.setBody("this is a test");
        content1_1.setLesson(lesson1);
        lessonDao.addContent(lesson1, content1_1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content1_1);

        log.debug("content1");
        CmCourseContent content1_2 = new CmCourseContentImpl();
        content1_2.setTitle("1.2 Title");
        content1_2.setBody("this is a test");
        content1_2.setLesson(lesson1);
        lessonDao.addContent(lesson1, content1_2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content1_2);

        CmCourseLesson lesson2 = new CmCourseLessonImpl();
        lesson2.setName("Android Services");
        lesson2.setTitle("Android Services");
        lesson2.setDescription("Android Services");
        lesson2.setKeywords("Platform, Service, Defining");
        lesson2.setOrder(1);
        lesson2.setInteractivityType(CmInteractivityType.A);
        lesson2.setInteractivityLevel(CmInteractivityLevel.B);
        lesson2.setDifficulty(CmDifficulty.EASY);
        moduleDao.addLesson(module1, lesson2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(lesson2);

        CmCourseContent content2_1 = new CmCourseContentImpl();
        content2_1.setTitle("2.1 Title");
        content2_1.setBody("this is a test");
        content2_1.setLesson(lesson1);
        lessonDao.addContent(lesson2, content2_1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content2_1);

        CmCourseContent content2_2 = new CmCourseContentImpl();
        content2_2.setTitle("2.2 Title");
        content2_2.setBody("this is a test");
        content2_2.setLesson(lesson1);
        lessonDao.addContent(lesson2, content2_2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content2_2);
    }

}
