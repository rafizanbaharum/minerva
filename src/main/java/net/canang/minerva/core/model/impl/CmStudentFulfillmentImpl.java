package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmStudentFulfillmentImpl implements CmStudentFulfillment {

    private Long id;
    private CmCourseSession course;
    private CmStudent student;
    private CmGrade finalGrade;

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
