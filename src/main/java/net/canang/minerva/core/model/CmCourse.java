package net.canang.minerva.core.model;

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
}
