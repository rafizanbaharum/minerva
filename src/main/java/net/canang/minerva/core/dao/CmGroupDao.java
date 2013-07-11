package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmGroup;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmGroupDao {

    CmGroup findGroupByName(String name);
}
