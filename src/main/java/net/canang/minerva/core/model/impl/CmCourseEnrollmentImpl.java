package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author rafizan.baharum
 * @since 7/20/13
 */
@Table(name = "CM_CORS_ENRN")
@Entity(name = "CmCourseEnrollment")
public class CmCourseEnrollmentImpl implements CmCourseEnrollment {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_ENRN")
    @SequenceGenerator(name = "SEQ_CM_CORS_ENRN", sequenceName = "SEQ_CM_CORS_ENRN", allocationSize = 1)
    private Long id;

    @NotNull
    @OneToOne(targetEntity = CmCourseSessionImpl.class)
    @JoinColumn(name = "COURSE_ID")
    private CmCourseSession course;

    @NotNull
    @OneToOne(targetEntity = CmStudentImpl.class)
    @JoinColumn(name = "STUDENT_ID")
    private CmStudent student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CmCourseSession getCourse() {
        return course;
    }

    public void setCourse(CmCourseSession course) {
        this.course = course;
    }

    public CmStudent getStudent() {
        return student;
    }

    public void setStudent(CmStudent student) {
        this.student = student;
    }
}
