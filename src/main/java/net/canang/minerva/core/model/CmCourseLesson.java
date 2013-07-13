package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseLesson extends CmMetaObject {

    String getName();

    String getTitle();

    String getDescription();

    String getKeywords();

    Integer getOrder();

    CmDifficulty getDifficulty();

    CmInteractivityType getInteractivityType();

    CmInteractivityLevel getInteractivityLevel();

}
