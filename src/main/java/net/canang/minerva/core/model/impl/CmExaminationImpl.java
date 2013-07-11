package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmExamination;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_EXAMINATION")
@Entity(name = "CmExamination")
public class CmExaminationImpl extends CmAssessmentImpl implements CmExamination {

}
