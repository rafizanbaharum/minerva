package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmSupport;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_SPPT")
@Entity(name = "CmSupport")
public class CmSupportImpl extends CmActorImpl implements CmSupport {

    public String getStaffNo() {
        return getIdentityNo();
    }

    public void setStaffNo(String staffNo) {
        setIdentityNo(staffNo);
    }

}
