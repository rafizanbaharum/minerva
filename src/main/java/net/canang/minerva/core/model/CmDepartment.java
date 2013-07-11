package net.canang.minerva.core.model;

import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmDepartment {

    String getCode();

    String getAlias();

    String getDescription();

    CmFaculty getFaculty();

    Set<CmUnit> getUnits();

}
