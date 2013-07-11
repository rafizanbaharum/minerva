package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmSession;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmSessionImpl implements CmSession {

    private Long id;
    private Date startDate;
    private Date endDate;
    private boolean active;
    private CmMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
