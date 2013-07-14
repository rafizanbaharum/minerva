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
public class CmCourseQuizDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(CmCourseQuizDaoTest.class);

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
    private CmCourseQuizDao quizDao;

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
        sessionFactory.getCurrentSession().refresh(department);

        // create our module
        createQuiz(course);
    }

    private void createQuiz(CmCourse course) {
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

        log.debug("quiz");
        CmCourseQuiz quiz1 = new CmCourseQuizImpl();
        quiz1.setTitle("Quiz 1");
        quiz1.setDescription("Quiz 1");
        quiz1.setModule(module1);
        moduleDao.addQuiz(module1, quiz1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(quiz1);

        CmCourseQuizSection section1 = new CmCourseQuizSectionImpl();
        section1.setTitle("1.1 Section 1");
        section1.setDescription("Section 1");
        quizDao.addSection(quiz1, section1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section1);

        CmCourseQuestion question1_1 = new CmCourseQuestionImpl();
        question1_1.setTitle("Title");
        question1_1.setBody("Question Body");
        quizDao.addQuestion(section1, question1_1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section1);
    }

}
