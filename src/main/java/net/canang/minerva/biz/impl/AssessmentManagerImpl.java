package net.canang.minerva.biz.impl;

import net.canang.minerva.biz.AssessmentManager;
import net.canang.minerva.core.model.CmCourseAssessment;
import net.canang.minerva.core.model.CmCourseQuiz;
import net.canang.minerva.core.model.CmCourseQuizQuestion;
import net.canang.minerva.core.model.CmCourseQuizSection;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/20/13
 */
public class AssessmentManagerImpl implements AssessmentManager {
    public void grade(CmCourseAssessment assessment) {

        switch (assessment.getAssessmentType()) {
            case QUIZ:
                grade(((CmCourseQuiz) assessment));
                break;
            case EXAMINATION:
                break;
            case ASSIGMENT:
                break;
            case TOPICAL:
                break;
        }
    }

    private void grade(CmCourseQuiz quiz) {
        List<CmCourseQuizSection> sections = quiz.getSections();
        for (CmCourseQuizSection section : sections) {
            List<CmCourseQuizQuestion> questions = section.getQuestions();
            for (CmCourseQuizQuestion question : questions) {
                String answerCode = question.getAnswerCode();
                if (answerCode == "todoresponsehere") {
                    // todo: increase point
                }
            }
        }
    }
}
