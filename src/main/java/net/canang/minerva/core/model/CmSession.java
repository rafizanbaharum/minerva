package net.canang.minerva.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmSession {

    Date getStartDate();

    Date getEndDate();

    boolean isActive();
}
