package net.canang.minerva.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmFlowdata {

    Long getDrafter();

    void setDrafter(Long registerer);

    Date getDraftedDate();

    void setDraftedDate(Date draftedDate);

    Long getRegisterer();

    void setRegisterer(Long registerer);

    Date getRegisteredDate();

    void setRegisteredDate(Date registeredDate);

    Long getVerifier();

    void setVerifier(Long verifier);

    Date getVerifiedDate();

    void setVerifiedDate(Date verifiedDate);

    Long getApprover();

    void setApprover(Long id);

    Date getApprovedDate();

    void setApprovedDate(Date approvedDate);

    CmFlowState getState();

    void setState(CmFlowState state);

}
