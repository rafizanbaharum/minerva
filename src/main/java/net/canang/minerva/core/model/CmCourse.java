package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourse extends CmMetaObject {

    String getCode();

    void setCode(String code);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    String getKeywords();

    void setKeywords(String keywords);

    CmDifficulty getDifficulty();

    void setDifficulty(CmDifficulty difficulty);

    CmInteractivityType getInteractivityType();

    void setInteractivityType(CmInteractivityType interactivityType);

    CmInteractivityLevel getInteractivityLevel();

    void setInteractivityLevel(CmInteractivityLevel interactivityLevel);

    CmDepartment getDepartment();

    void setDepartment(CmDepartment department);

    List<CmCourseModule> getModules();

    void setModules(List<CmCourseModule> modules);

    List<CmCourseAsset> getAssets();

    void setAssets(List<CmCourseAsset> assets);

}
