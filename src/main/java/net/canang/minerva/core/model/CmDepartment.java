package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmDepartment {

    String getCode();

    void setCode(String code);

    String getAlias();

    void setAlias(String alias);

    String getDescription();

    void setDescription(String description);

    CmFaculty getFaculty();

    void setFaculty(CmFaculty faculty);

    List<CmUnit> getUnits();

    void setUnits(List<CmUnit> units);

}
