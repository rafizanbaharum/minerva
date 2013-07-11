package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmGradeImpl implements CmGrade {

    private Long id;
    private CmStudent student;
    private CmAssessment assessment;
    private CmGradeBook book;

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

    public CmGradeBook getBook() {
        return book;
    }

    public void setBook(CmGradeBook book) {
        this.book = book;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
