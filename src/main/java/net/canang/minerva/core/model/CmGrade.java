package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmGrade extends CmMetaObject{

    CmGradeBook getBook();

    CmStudent getStudent();

    CmAssessment getAssessment();

}
