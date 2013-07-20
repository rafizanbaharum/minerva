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
    public void createFaculty() {
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
    }

    @Test
    @Rollback(value = false)
    public void createCourse() {
        CmDepartment department = departmentDao.findByCode("CS");
        log.debug("course");
        CmCourse course = new CmCourseImpl();
        course.setCode("CS101");
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
    }

    @Test
    @Rollback(value = false)
    public void createModule1() {
        log.debug("module");
        CmCourse course = courseDao.findByCode("CS101");
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
        lesson1.setTitle("1. Android Services");
        lesson1.setDescription("Android Services");
        lesson1.setKeywords("Platform, Service, Defining");
        lesson1.setOrder(1);
        lesson1.setSectionShown(false);
        lesson1.setInteractivityType(CmInteractivityType.A);
        lesson1.setInteractivityLevel(CmInteractivityLevel.B);
        lesson1.setDifficulty(CmDifficulty.EASY);
        moduleDao.addLesson(module1, lesson1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(lesson1);

        CmCourseLessonSection section1 = new CmCourseLessonSectionImpl();
        section1.setTitle("1. Defining Service");
        section1.setDescription("Section 1");
        section1.setOrder(1);
        lessonDao.addSection(lesson1, section1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section1);

        log.debug("content1");
        CmCourseLessonContent content1_1 = new CmCourseLessonContentImpl();
        content1_1.setTitle("1.1 Title");
        content1_1.setBody("this is a test");
        content1_1.setOrder(1);
        content1_1.setSection(section1);
        lessonDao.addContent(section1, content1_1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content1_1);

        log.debug("content1");
        CmCourseLessonContent content1_2 = new CmCourseLessonContentImpl();
        content1_2.setTitle("1.2 Title");
        content1_2.setBody("this is a test");
        content1_2.setOrder(2);
        content1_2.setSection(section1);
        lessonDao.addContent(section1, content1_2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content1_2);

        CmCourseLessonSection section2 = new CmCourseLessonSectionImpl();
        section2.setTitle("2. Broadcasting Service");
        section2.setDescription("Section 2");
        section2.setOrder(2);
        lessonDao.addSection(lesson1, section2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section2);

        CmCourseLessonContent content2_1 = new CmCourseLessonContentImpl();
        content2_1.setTitle("2.1 Title");
        content2_1.setBody("this is a test");
        content2_1.setOrder(1);
        content2_1.setSection(section2);
        lessonDao.addContent(section2, content2_1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content2_1);

        CmCourseLessonContent content2_2 = new CmCourseLessonContentImpl();
        content2_2.setTitle("2.2 Title");
        content2_2.setBody("this is a test");
        content2_2.setOrder(2);
        content2_2.setSection(section2);
        lessonDao.addContent(section2, content2_2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content2_2);

        CmCourseLessonSection section3 = new CmCourseLessonSectionImpl();
        section3.setTitle("3. Starting Service");
        section3.setDescription("Section 3");
        section3.setOrder(3);
        lessonDao.addSection(lesson1, section3, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section3);

        CmCourseLessonContent content3_1 = new CmCourseLessonContentImpl();
        content3_1.setTitle("3.1 Title");
        content3_1.setBody("this is a test");
        content3_1.setOrder(1);
        content3_1.setSection(section3);
        lessonDao.addContent(section3, content3_1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content3_1);

        CmCourseLessonContent content3_2 = new CmCourseLessonContentImpl();
        content3_2.setTitle("3.2 Title");
        content3_2.setBody("this is a test");
        content3_2.setOrder(2);
        content3_2.setSection(section3);
        lessonDao.addContent(section3, content3_2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content3_2);

        CmCourseLessonSection section4 = new CmCourseLessonSectionImpl();
        section4.setTitle("4. Communicating with Service");
        section4.setDescription("Section 3");
        section4.setOrder(4);
        lessonDao.addSection(lesson1, section4, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section4);

        CmCourseLessonContent content4_1 = new CmCourseLessonContentImpl();
        content4_1.setTitle("4.1 Title");
        content4_1.setBody("this is a test");
        content4_1.setOrder(1);
        content4_1.setSection(section4);
        lessonDao.addContent(section4, content4_1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content4_1);

        CmCourseLessonContent content4_2 = new CmCourseLessonContentImpl();
        content4_2.setTitle("4.2 Title");
        content4_2.setBody("this is a test");
        content4_2.setOrder(2);
        content4_2.setSection(section4);
        lessonDao.addContent(section4, content4_2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content4_2);
    }

    @Test
    @Rollback(value = false)
    public void createModule2() {
        log.debug("module");
        CmCourse course = courseDao.findByCode("CS101");
        CmCourseModule module1 = new CmCourseModuleImpl();
        module1.setName("Android Background Processing");
        module1.setTitle("Android Background Processing with Threads");
        module1.setDescription("This tutorial describes the usage of Threads, Handlers and AsyncTask in your application. It also covers how to handle the application lifecycle together with threads. It is based on Eclipse 4.2, Java 1.6 and Android 4.2.");
        module1.setKeywords("Android, Background, Thread");
        module1.setOrder(2);
        module1.setCourse(course);
        courseDao.addModule(course, module1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(module1);

        log.debug("lesson");
        CmCourseLesson lesson1 = new CmCourseLessonImpl();
        lesson1.setTitle("Android's user interface thread");
        lesson1.setDescription("Android Thread");
        lesson1.setKeywords("Thread");
        lesson1.setOrder(1);
        lesson1.setSectionShown(false);
        lesson1.setInteractivityType(CmInteractivityType.A);
        lesson1.setInteractivityLevel(CmInteractivityLevel.B);
        lesson1.setDifficulty(CmDifficulty.EASY);
        moduleDao.addLesson(module1, lesson1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(lesson1);

        CmCourseLessonSection section1 = new CmCourseLessonSectionImpl();
        section1.setTitle("1. Section 1");
        section1.setDescription("Section 1");
        lessonDao.addSection(lesson1, section1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section1);

        log.debug("content1");
        CmCourseLessonContent content1_1 = new CmCourseLessonContentImpl();
        content1_1.setTitle("Main thread");
        content1_1.setBody("this is a test");
        content1_1.setSection(section1);
        lessonDao.addContent(section1, content1_1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content1_1);

        log.debug("content1");
        CmCourseLessonContent content1_2 = new CmCourseLessonContentImpl();
        content1_2.setTitle("Why using concurrency");
        content1_2.setBody("this is a test");
        content1_2.setSection(section1);
        lessonDao.addContent(section1, content1_2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content1_2);

        CmCourseLessonSection section2 = new CmCourseLessonSectionImpl();
        section2.setTitle("Using Java threading in Android");
        section2.setDescription("Section 2");
        lessonDao.addSection(lesson1, section2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section2);

        CmCourseLessonContent content2_1 = new CmCourseLessonContentImpl();
        content2_1.setTitle("3.2. Disadvantages of using Java threads in Android");
        content2_1.setBody("this is a test");
        content2_1.setSection(section2);
        lessonDao.addContent(section2, content2_1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content2_1);

        CmCourseLessonContent content2_2 = new CmCourseLessonContentImpl();
        content2_2.setTitle("Using Java threading in Android");
        content2_2.setBody("this is a test");
        content2_2.setSection(section2);
        lessonDao.addContent(section2, content2_2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content2_2);

        CmCourseLessonSection section3 = new CmCourseLessonSectionImpl();
        section3.setTitle("4. Concurrency constructs in Android");
        section3.setDescription("Section 3");
        lessonDao.addSection(lesson1, section3, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section3);

        CmCourseLessonContent content3_1 = new CmCourseLessonContentImpl();
        content3_1.setTitle("3.1 Title");
        content3_1.setBody("this is a test");
        content3_1.setSection(section3);
        lessonDao.addContent(section3, content3_1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content3_1);

        CmCourseLessonContent content3_2 = new CmCourseLessonContentImpl();
        content3_2.setTitle("5.2. Creating and reusing instances of Handlers");
        content3_2.setBody("this is a test");
        content3_2.setSection(section3);
        lessonDao.addContent(section3, content3_2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content3_2);

        CmCourseLessonSection section4 = new CmCourseLessonSectionImpl();
        section4.setTitle("5.3. Example");
        section4.setDescription("Section 3");
        lessonDao.addSection(lesson1, section4, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section4);

        CmCourseLessonContent content4_1 = new CmCourseLessonContentImpl();
        content4_1.setTitle("5.3. Example");
        content4_1.setBody("'''  // Reuse existing handler if you don't \n" +
                "// have to override the message processing\n" +
                "handler = getWindow().getDecorView().getHandler();  '''");
        content4_1.setSection(section4);
        lessonDao.addContent(section4, content4_1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content4_1);

        CmCourseLessonContent content4_2 = new CmCourseLessonContentImpl();
        content4_2.setTitle("4.2 Title");
        content4_2.setBody("this is a test");
        content4_2.setSection(section4);
        lessonDao.addContent(section4, content4_2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(content4_2);
    }
}
