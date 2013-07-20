package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseEnrollment {

    CmCourseSession getCourse();

    void setCourse(CmCourseSession session);

    CmStudent getStudent();

    void setStudent(CmStudent student);
}
