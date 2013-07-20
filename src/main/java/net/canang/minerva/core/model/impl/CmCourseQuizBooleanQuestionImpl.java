package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseQuizBooleanQuestion;
import net.canang.minerva.core.model.CmQuestionType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_QUIZ_BOLN_QSTN")
@Entity(name = "CmCourseBooleanQuestion")
public class CmCourseQuizBooleanQuestionImpl extends CmCourseQuizQuestionImpl implements CmCourseQuizBooleanQuestion {

    @Column(name = "ANSWER_TRUE")
    private String answerTrue;

    @Column(name = "ANSWER_FALSE")
    private String answerFalse;

    public CmCourseQuizBooleanQuestionImpl() {
        setQuestionType(CmQuestionType.BOOLEAN);
    }

    public String getAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(String answerTrue) {
        this.answerTrue = answerTrue;
    }

    public String getAnswerFalse() {
        return answerFalse;
    }

    public void setAnswerFalse(String answerFalse) {
        this.answerFalse = answerFalse;
    }
}
