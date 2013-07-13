package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
@Table(name = "CM_GRBK")
@Entity(name = "CmGradebook")
public class CmGradebookImpl implements CmGradebook {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_GRBK")
    @SequenceGenerator(name = "SEQ_CM_GRBK", sequenceName = "SEQ_CM_GRBK", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = CmCourseSessionImpl.class)
    @JoinColumn(name = "COURSE_ID")
    private CmCourseSession course;

    @OneToMany(targetEntity = CmGradeImpl.class, mappedBy = "gradebook")
    private List<CmGrade> grades;

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

    public List<CmGrade> getGrades() {
        return grades;
    }

    public void setGrades(List<CmGrade> grades) {
        this.grades = grades;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
