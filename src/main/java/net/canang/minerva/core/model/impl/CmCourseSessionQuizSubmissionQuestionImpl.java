package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseSessionQuizSubmissionQuestion;
import net.canang.minerva.core.model.CmQuestionType;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_SESN_QUIZ_SMSN_QSTN")
@Entity(name = "CmCourseSessionQuizSubmissionQuestion")
public class CmCourseSessionQuizSubmissionQuestionImpl extends CmCourseSessionQuizQuestionImpl implements CmCourseSessionQuizSubmissionQuestion {

    public CmCourseSessionQuizSubmissionQuestionImpl() {
        setQuestionType(CmQuestionType.MULTIPLE_SUBMISSION);
    }
}
