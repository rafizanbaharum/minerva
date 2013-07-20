package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseAssessmentType;
import net.canang.minerva.core.model.CmCourseExamination;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_EXMN")
@Entity(name = "CmCourseExamination")
public class CmCourseExaminationImpl extends CmCourseAssessmentImpl implements CmCourseExamination {

    public CmCourseExaminationImpl() {
        setAssessmentType(CmCourseAssessmentType.EXAMINATION);
    }
}
