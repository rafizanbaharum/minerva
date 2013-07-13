package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_GRDE")
@Entity(name = "CmGrade")
public class CmGradeImpl implements CmGrade {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_GRDE")
    @SequenceGenerator(name = "SEQ_CM_GRDE", sequenceName = "SEQ_CM_GRDE", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = CmStudentImpl.class)
    @JoinColumn(name = "STUDENT_ID")
    private CmStudent student;

    @OneToOne(targetEntity = CmAssessmentImpl.class)
    @JoinColumn(name = "ASSESSMENT_ID")
    private CmAssessment assessment;

    @OneToOne(targetEntity = CmGradebookImpl.class)
    @JoinColumn(name = "GRADEBOOK_ID")
    private CmGradebook gradebook;

    @Embedded
    private CmMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CmStudent getStudent() {
        return student;
    }

    public void setStudent(CmStudent student) {
        this.student = student;
    }

    public CmAssessment getAssessment() {
        return assessment;
    }

    public void setAssessment(CmAssessment assessment) {
        this.assessment = assessment;
    }

    public CmGradebook getGradebook() {
        return gradebook;
    }

    public void setGradebook(CmGradebook gradebook) {
        this.gradebook = gradebook;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
