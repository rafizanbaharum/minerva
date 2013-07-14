package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmStudentFulfillment extends CmMetaObject {

    CmCourseSession getCourse();

    void setCourse(CmCourseSession course);

    CmStudent getStudent();

    void setStudent(CmStudent student);

    CmGrade getFinalGrade();

    void setFinalGrade(CmGrade finalGrade);
}
