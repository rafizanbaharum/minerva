package net.canang.minerva.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmSession {

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);

    boolean isActive();

    void setActive(boolean active);
}
