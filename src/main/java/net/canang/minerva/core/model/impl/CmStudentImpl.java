package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmActorType;
import net.canang.minerva.core.model.CmStudent;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_STDN")
@Entity(name = "CmStudent")
public class CmStudentImpl extends CmActorImpl implements CmStudent {

    public CmStudentImpl() {
        setActorType(CmActorType.STUDENT);
    }

    public String getMatrixNo() {
        return getIdentityNo();
    }

    public void setMatrixNo(String matrixNo) {
        setIdentityNo(matrixNo);
    }


}
