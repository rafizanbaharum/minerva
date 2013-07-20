package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseQuizSubjectiveQuestion extends CmCourseQuizQuestion {

    CmSubjectiveQuestionType getSubjectiveType();

    void setSubjectiveType(CmSubjectiveQuestionType subjectiveType);
}

