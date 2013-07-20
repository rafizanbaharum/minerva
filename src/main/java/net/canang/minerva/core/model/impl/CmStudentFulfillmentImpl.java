package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_STDN_FLMN")
@Entity(name = "CmStudentFulfillment")
public class CmStudentFulfillmentImpl implements CmStudentFulfillment {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_STDN_FLMN")
    @SequenceGenerator(name = "SEQ_CM_STDN_FLMN", sequenceName = "SEQ_CM_STDN_FLMN", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = CmCourseSessionImpl.class)
    @JoinColumn(name = "COURSE_ID")
    private CmCourseSession course;

    @OneToOne(targetEntity = CmStudentImpl.class)
    @JoinColumn(name = "STUDENT_ID")
    private CmStudent student;

    @OneToOne(targetEntity = CmGradeImpl.class)
    @JoinColumn(name = "GRADE_ID")
    private CmGrade finalGrade;

    @Embedded
    private CmMetadata metadata;

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

    public CmGrade getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(CmGrade finalGrade) {
        this.finalGrade = finalGrade;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
