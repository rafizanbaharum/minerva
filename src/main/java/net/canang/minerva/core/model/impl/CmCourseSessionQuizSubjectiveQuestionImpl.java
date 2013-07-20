package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseSessionQuizSubjectiveQuestion;
import net.canang.minerva.core.model.CmQuestionType;
import net.canang.minerva.core.model.CmSubjectiveQuestionType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_SESN_QUIZ_SJTV_QSTN")
@Entity(name = "CmCourseSessionQuizSubjectiveQuestion")
public class CmCourseSessionQuizSubjectiveQuestionImpl extends CmCourseSessionQuizQuestionImpl implements CmCourseSessionQuizSubjectiveQuestion {

    @Column(name = "SUBJECTIVE_TYPE")
    private CmSubjectiveQuestionType subjectiveType;

    public CmCourseSessionQuizSubjectiveQuestionImpl() {
        setQuestionType(CmQuestionType.SUBJECTIVE);
    }

    public CmSubjectiveQuestionType getSubjectiveType() {
        return subjectiveType;
    }

    public void setSubjectiveType(CmSubjectiveQuestionType subjectiveType) {
        this.subjectiveType = subjectiveType;
    }
}
