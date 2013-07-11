package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_COURSE_REGISTRATION")
@Entity(name = "CmCourseRegistration")
public class CmCourseRegistrationImpl implements CmCourseRegistration {

    private Long id;
    private String referenceNo;
    private String sourceNo;
    private boolean required;
    private CmSession session;
    private CmCourse course;
    private CmStudent student;

    private CmMetadata metadata;
    private CmFlowdata flowdata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
    }

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

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }

    public CmFlowdata getFlowdata() {
        return flowdata;
    }

    public void setFlowdata(CmFlowdata flowdata) {
        this.flowdata = flowdata;
    }
}
