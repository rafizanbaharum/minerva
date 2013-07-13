package net.canang.minerva.core.model.impl;

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

    public String getMatrixNo() {
        return getIdentityNo();
    }

    void setMatrixNo(String matrixNo) {
        setIdentityNo(matrixNo);
    }
}
