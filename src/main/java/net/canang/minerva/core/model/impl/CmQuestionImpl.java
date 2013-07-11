package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseSession;
import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmQuestion;
import net.canang.minerva.core.model.CmStudent;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmQuestionImpl implements CmQuestion {

    private Long id;
    private CmCourseSession course;
    private CmStudent student;

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

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
