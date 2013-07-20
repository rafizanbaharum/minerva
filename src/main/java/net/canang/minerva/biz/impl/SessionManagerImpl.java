package net.canang.minerva.biz.impl;

import net.canang.minerva.biz.ManagerSupport;
import net.canang.minerva.biz.SessionManager;
import net.canang.minerva.core.dao.CmCourseSessionDao;
import net.canang.minerva.core.dao.CmCourseSessionLessonDao;
import net.canang.minerva.core.dao.CmCourseSessionModuleDao;
import net.canang.minerva.core.dao.CmCourseSessionQuizDao;
import net.canang.minerva.core.model.*;
import net.canang.minerva.core.model.impl.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/20/13
 */
@Transactional
@Component("sessionManager")
public class SessionManagerImpl extends ManagerSupport implements SessionManager {

    @Autowired
    private CmCourseSessionDao courseDao;

    @Autowired
    private CmCourseSessionModuleDao moduleDao;

    @Autowired
    private CmCourseSessionLessonDao lessonDao;

    @Autowired
    private CmCourseSessionQuizDao quizDao;

    @Autowired
    private SessionFactory sessionFactory;


    public void serializeToCourseSession(CmSession session, CmCourse course) {
        CmCourseSession courseSession = new CmCourseSessionImpl();
        courseSession.setCode(course.getCode());
        courseSession.setName(course.getDescription());
        courseSession.setDescription(course.getDescription());
        courseSession.setKeywords(course.getKeywords());
        courseSession.setDifficulty(course.getDifficulty());
        courseSession.setInteractivityLevel(course.getInteractivityLevel());
        courseSession.setInteractivityType(course.getInteractivityType());
        courseSession.setDepartment(course.getDepartment());
        courseSession.setSession(session);
        courseDao.save(courseSession, getCurrentUser());
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(courseSession);
        serializeToCourseSessionModule(courseSession, course.getModules());

    }

    private void serializeToCourseSessionModule(CmCourseSession course, List<CmCourseModule> modules) {
        for (CmCourseModule module : modules) {
            CmCourseSessionModule sessionModule = new CmCourseSessionModuleImpl();
            sessionModule.setName(module.getName());
            sessionModule.setTitle(module.getTitle());
            sessionModule.setDescription(module.getDescription());
            sessionModule.setKeywords(module.getKeywords());
            sessionModule.setOrder(module.getOrder());
            sessionModule.setCourse(course);
            courseDao.addModule(course, sessionModule, getCurrentUser());
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(sessionModule);
            serializeToCourseSessionLesson(sessionModule, module.getLessons());
        }
    }

    // ==================================================================================================
    // LESSON
    // ==================================================================================================

    private void serializeToCourseSessionLesson(CmCourseSessionModule module, List<CmCourseLesson> lessons) {
        for (CmCourseLesson lesson : lessons) {
            CmCourseSessionLesson sessionLesson = new CmCourseSessionLessonImpl();
            sessionLesson.setTitle(lesson.getTitle());
            sessionLesson.setDescription(lesson.getDescription());
            sessionLesson.setKeywords(lesson.getKeywords());
            sessionLesson.setOrder(lesson.getOrder());
            sessionLesson.setSectionShown(lesson.isSectionShown());
            sessionLesson.setModule(module);
            moduleDao.addLesson(module, sessionLesson, getCurrentUser());
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(sessionLesson);
            serializeToCourseSessionSection(sessionLesson, lesson.getSections());
        }
    }

    private void serializeToCourseSessionSection(CmCourseSessionLesson lesson, List<CmCourseLessonSection> sections) {
        for (CmCourseLessonSection section : sections) {
            CmCourseSessionLessonSection sessionSection = new CmCourseSessionLessonSectionImpl();
            sessionSection.setTitle(section.getTitle());
            sessionSection.setDescription(section.getDescription());
            sessionSection.setOrder(section.getOrder());
            sessionSection.setLesson(lesson);
            lessonDao.addSection(lesson, sessionSection, getCurrentUser());
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(sessionSection);
            serializeToCourseSessionContent(sessionSection, section.getContents());
        }
    }

    private void serializeToCourseSessionContent(CmCourseSessionLessonSection section, List<CmCourseLessonContent> contents) {
        for (CmCourseLessonContent content : contents) {
            CmCourseSessionLessonContent sessionContent = new CmCourseSessionLessonContentImpl();
            sessionContent.setTitle(content.getTitle());
            sessionContent.setBody(content.getBody());
            sessionContent.setOrder(content.getOrder());
            sessionContent.setSection(section);
            lessonDao.addContent(section, sessionContent, getCurrentUser());
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(sessionContent);
        }
    }

    // ==================================================================================================
    // ASSESSMENT
    // ==================================================================================================

    private void serializeToCourseSessionAssessment(CmCourseSessionModule module, List<CmCourseAssessment> assessments) {
        for (CmCourseAssessment assessment : assessments) {
            CmCourseSessionAssessment sessionAssessment = newInstance(assessment.getAssessmentType());
            sessionAssessment.setTitle(assessment.getTitle());
            sessionAssessment.setDescription(assessment.getDescription());
            sessionAssessment.setOrder(assessment.getOrder());
            sessionAssessment.setSectionShown(assessment.isSectionShown());
            sessionAssessment.setModule(module);
            moduleDao.addAssessment(module, sessionAssessment, getCurrentUser());
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(sessionAssessment);

            switch (assessment.getAssessmentType()) {
                case QUIZ:
                    serializeToCourseSessionQuizSection(((CmCourseSessionQuiz) sessionAssessment), ((CmCourseQuiz) assessment).getSections());
                    break;
                case EXAMINATION:
                    break;
                case ASSIGMENT:
                    break;
                case TOPICAL:
                    break;
            }
        }
    }

    private void serializeToCourseSessionQuizSection(CmCourseSessionQuiz quiz, List<CmCourseQuizSection> sections) {
        for (CmCourseQuizSection section : sections) {
            CmCourseSessionQuizSection sessionSection = new CmCourseSessionQuizSectionImpl();
            sessionSection.setTitle(section.getTitle());
            sessionSection.setDescription(section.getDescription());
            sessionSection.setOrder(section.getOrder());
            sessionSection.setQuiz(quiz);
            quizDao.addSection(quiz, sessionSection, getCurrentUser());
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(sessionSection);
            serializeToCourseSessionQuizQuestion(sessionSection, section.getQuestions());
        }
    }

    private void serializeToCourseSessionQuizQuestion(CmCourseSessionQuizSection section, List<CmCourseQuizQuestion> questions) {
        for (CmCourseQuizQuestion question : questions) {
            CmCourseSessionQuizQuestion sessionQuestion = newInstance(question.getQuestionType());
            sessionQuestion.setTitle(question.getTitle());
            sessionQuestion.setBody(question.getBody());
            sessionQuestion.setOrder(question.getOrder());
            sessionQuestion.setSection(section);
            quizDao.addQuestion(section, sessionQuestion, getCurrentUser());
            sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().refresh(sessionQuestion);
        }
    }

    private CmCourseSessionQuizQuestion newInstance(CmQuestionType type) {
        CmCourseSessionQuizQuestion question = null;
        switch (type) {
            case MULTIPLE_CHOICE:
                question = new CmCourseSessionQuizMultipleChoiceQuestionImpl();
                break;
            case BOOLEAN:
                question = new CmCourseSessionQuizBooleanQuestionImpl();
                break;
            case SUBJECTIVE:
                question = new CmCourseSessionQuizSubjectiveQuestionImpl();
                break;
            case SUBMISSION:
                question = new CmCourseSessionQuizSubmissionQuestionImpl();
                break;
            case MULTIPLE_SUBMISSION:
                question = new CmCourseSessionQuizSubmissionQuestionImpl();
                break;
        }
        return question;
    }

    private CmCourseSessionAssessment newInstance(CmCourseAssessmentType assessmentType) {
        CmCourseSessionAssessment assessment = null;
        switch (assessmentType) {
            case QUIZ:
                assessment = new CmCourseSessionQuizImpl();
                break;
            case EXAMINATION:
                break;
            case ASSIGMENT:
                break;
            case TOPICAL:
                break;
        }
        return assessment;
    }

}
