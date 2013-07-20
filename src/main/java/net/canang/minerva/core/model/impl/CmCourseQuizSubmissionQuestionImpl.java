package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseQuizSubmissionQuestion;
import net.canang.minerva.core.model.CmQuestionType;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_QUIZ_SMSN_QSTN")
@Entity(name = "CmCourseQuizSubmissionQuestion")
public class CmCourseQuizSubmissionQuestionImpl extends CmCourseQuizQuestionImpl implements CmCourseQuizSubmissionQuestion {

    public CmCourseQuizSubmissionQuestionImpl() {
        setQuestionType(CmQuestionType.MULTIPLE_SUBMISSION);
    }
}
