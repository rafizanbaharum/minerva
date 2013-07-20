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

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CmCoreConfig.class})
public class CmCourseAssessmentDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(CmCourseAssessmentDaoTest.class);

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
        CmCourse course = courseDao.findByCode("CS101");
        List<CmCourseModule> modules = course.getModules();
        for (CmCourseModule module : modules) {
            createQuiz(module);
        }
    }

    private void createQuiz(CmCourseModule module) {
        log.debug("quiz");
        CmCourseQuiz quiz1 = new CmCourseQuizImpl();
        quiz1.setTitle("Quiz 1");
        quiz1.setDescription("Quiz 1");
        quiz1.setModule(module);
        quiz1.setSectionShown(false);
        quiz1.setOrder(1);
        moduleDao.addAssessment(module, quiz1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(quiz1);

        CmCourseQuizSection section1 = new CmCourseQuizSectionImpl();
        section1.setTitle("1.1 Section 1");
        section1.setDescription("Section 1");
        section1.setOrder(1);
        quizDao.addSection(quiz1, section1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section1);

        CmCourseQuizMultipleChoiceQuestion question1_1 = new CmCourseQuizMultipleChoiceQuestionImpl();
        question1_1.setTitle("Title");
        question1_1.setBody("Question Body");
        question1_1.setAnswer1("Answer A");
        question1_1.setAnswer2("Answer B");
        question1_1.setAnswer3("Answer C");
        question1_1.setAnswer4("Answer D");
        question1_1.setAnswerCode("A");
        question1_1.setOrder(1);
        quizDao.addQuestion(section1, question1_1, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section1);

        CmCourseQuizBooleanQuestion question1_2 = new CmCourseQuizBooleanQuestionImpl();
        question1_2.setTitle("Title");
        question1_2.setBody("Question Body");
        question1_2.setAnswerTrue("True");
        question1_2.setAnswerFalse("False");
        question1_2.setAnswerCode("T");
        question1_2.setOrder(2);
        quizDao.addQuestion(section1, question1_2, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section1);

        CmCourseQuizSubjectiveQuestion question1_3 = new CmCourseQuizSubjectiveQuestionImpl();
        question1_3.setTitle("Title");
        question1_3.setBody("Question Body");
        question1_3.setSubjectiveType(CmSubjectiveQuestionType.SHORT);
        question1_3.setOrder(3);
        quizDao.addQuestion(section1, question1_3, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section1);

        CmCourseQuizSubjectiveQuestion question1_4 = new CmCourseQuizSubjectiveQuestionImpl();
        question1_4.setTitle("Title");
        question1_4.setBody("Question Body");
        question1_4.setSubjectiveType(CmSubjectiveQuestionType.LONG);
        question1_4.setOrder(4);
        quizDao.addQuestion(section1, question1_4, root);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(section1);
    }
}
