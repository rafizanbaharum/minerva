package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmGrade extends CmMetaObject{

    CmGradebook getGradebook();

    CmStudent getStudent();

    CmAssessment getAssessment();

}
