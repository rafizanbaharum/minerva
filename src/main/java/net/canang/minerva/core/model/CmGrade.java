package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmGrade extends CmMetaObject {

    CmGradebook getGradebook();

    void setGradebook(CmGradebook gradebook);

    CmStudent getStudent();

    void setStudent(CmStudent student);

    CmCourseAssessment getAssessment();

    void setAssessment(CmCourseAssessment assessment);

}
