package net.canang.minerva.core;

import net.canang.minerva.core.model.CmUser;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmUserDao {

    CmUser findByUsername(String username);
}
