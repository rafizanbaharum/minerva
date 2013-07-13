package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_RGTN")
@Entity(name = "CmCourseRegistration")
public class CmCourseRegistrationImpl extends CmDocumentImpl implements CmCourseRegistration {

    @Column(name = "REQUIRED")
    private boolean required;

    @OneToOne(targetEntity = CmSessionImpl.class)
    @JoinColumn(name = "SESSION_ID")
    private CmSession session;

    @OneToOne(targetEntity = CmCourseImpl.class)
    @JoinColumn(name = "COURSE_ID")
    private CmCourse course;

    @OneToOne(targetEntity = CmStudentImpl.class)
    @JoinColumn(name = "STUDENT_ID")
    private CmStudent student;

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public CmSession getSession() {
        return session;
    }

    public void setSession(CmSession session) {
        this.session = session;
    }

    public CmCourse getCourse() {
        return course;
    }

    public void setCourse(CmCourse course) {
        this.course = course;
    }

    public CmStudent getStudent() {
        return student;
    }

    public void setStudent(CmStudent student) {
        this.student = student;
    }
}
