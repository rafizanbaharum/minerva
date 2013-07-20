package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseAssessmentType;
import net.canang.minerva.core.model.CmCourseExamination;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_SESN_EXMN")
@Entity(name = "CmCourseSessionExamination")
public class CmCourseSessionExaminationImpl extends CmCourseAssessmentImpl implements CmCourseExamination {

    public CmCourseSessionExaminationImpl() {
        setAssessmentType(CmCourseAssessmentType.EXAMINATION);
    }
}
