package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourse extends CmMetaObject {

    String getName();

    String getDescription();

    String getKeywords();

    CmDifficulty getDifficulty();

    CmInteractivityType getInteractivityType();

    CmInteractivityLevel getInteractivityLevel();

    CmDepartment getDepartment();

    List<CmCourseModule> getModules();

    List<CmCourseAsset> getAssets();
}
