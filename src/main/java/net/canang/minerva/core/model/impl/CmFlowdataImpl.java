package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmFlowState;
import net.canang.minerva.core.model.CmFlowdata;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmFlowdataImpl implements CmFlowdata {
    private Long requester;
    private Date requestedDate;
    private Long registerer;
    private Date registeredDate;
    private Long verifier;
    private Date verifiedDate;
    private Long approver;
    private Date approvedDate;
    private CmFlowState state;

    public Long getRequester() {
        return requester;
    }

    public void setRequester(Long requester) {
        this.requester = requester;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Long getRegisterer() {
        return registerer;
    }

    public void setRegisterer(Long registerer) {
        this.registerer = registerer;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Long getVerifier() {
        return verifier;
    }

    public void setVerifier(Long verifier) {
        this.verifier = verifier;
    }

    public Date getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(Date verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public Long getApprover() {
        return approver;
    }

    public void setApprover(Long approver) {
        this.approver = approver;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public CmFlowState getState() {
        return state;
    }

    public void setState(CmFlowState state) {
        this.state = state;
    }
}
