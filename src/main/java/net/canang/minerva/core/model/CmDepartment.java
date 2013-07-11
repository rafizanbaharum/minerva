package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmDepartment {

    String getCode();

    String getAlias();

    String getDescription();

    CmFaculty getFaculty();

    List<CmUnit> getUnits();

}
