package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseSessionQuizMultipleChoiceQuestion;
import net.canang.minerva.core.model.CmQuestionType;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_SESN_QUIZ_MCHC_QSTN")
@Entity(name = "CmCourseSessionQuizMultipleChoiceQuestion")
@Inheritance(strategy = InheritanceType.JOINED)
public class CmCourseSessionQuizMultipleChoiceQuestionImpl extends CmCourseSessionQuizQuestionImpl implements CmCourseSessionQuizMultipleChoiceQuestion {

    @Column(name = "ANSWER1")
    private String answer1;

    @Column(name = "ANSWER2")
    private String answer2;

    @Column(name = "ANSWER3")
    private String answer3;

    @Column(name = "ANSWER4")
    private String answer4;

    public CmCourseSessionQuizMultipleChoiceQuestionImpl() {
        setQuestionType(CmQuestionType.MULTIPLE_CHOICE);
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }
}
