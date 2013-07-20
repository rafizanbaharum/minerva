package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseQuizSubjectiveQuestion;
import net.canang.minerva.core.model.CmQuestionType;
import net.canang.minerva.core.model.CmSubjectiveQuestionType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_QUIZ_SJTV_QSTN")
@Entity(name = "CmCourseQuizSubjectiveQuestion")
public class CmCourseQuizSubjectiveQuestionImpl extends CmCourseQuizQuestionImpl implements CmCourseQuizSubjectiveQuestion {

    @Column(name = "SUBJECTIVE_TYPE")
    private CmSubjectiveQuestionType subjectiveType;

    public CmCourseQuizSubjectiveQuestionImpl() {
        setQuestionType(CmQuestionType.SUBJECTIVE);
    }

    public CmSubjectiveQuestionType getSubjectiveType() {
        return subjectiveType;
    }

    public void setSubjectiveType(CmSubjectiveQuestionType subjectiveType) {
        this.subjectiveType = subjectiveType;
    }
}
