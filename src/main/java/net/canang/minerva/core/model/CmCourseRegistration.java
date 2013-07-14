package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseRegistration extends CmDocument {

    CmSession getSession();

    void setSession(CmSession session);

    CmCourse getCourse();

    void setCourse(CmCourse course);

    CmStudent getStudent();

    void setStudent(CmStudent student);

    boolean isRequired();

    void setRequired(boolean required);
}
