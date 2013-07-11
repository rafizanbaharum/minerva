package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseSessionLesson extends CmMetaObject{

    String getName();

    String getTitle();

    String getDescription();

    String getKeywords();

    Integer getOrder();

    CmDifficulty getDifficulty();

    CmInteractivityType getInteractivityType();

    CmInteractivityLevel getInteractivityLevel();

}
