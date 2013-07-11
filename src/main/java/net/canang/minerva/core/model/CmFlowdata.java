package net.canang.minerva.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmFlowdata {

    Long getRegisterer();

    Date getRegisteredDate();

    Long getVerifier();

    Date getVerifiedDate();

    Long getApprover();

    Date getApprovedDate();

    CmFlowState getState();
}
