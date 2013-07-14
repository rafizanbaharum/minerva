package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseSessionLesson extends CmMetaObject{

    String getName();

    void setName(String name);

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    String getKeywords();

    void setKeywords(String keywords);

    Integer getOrder();

    void setOrder(Integer order);

    CmDifficulty getDifficulty();

    void setDifficulty(CmDifficulty difficulty);

    CmInteractivityType getInteractivityType();

    void setInteractivityType(CmInteractivityType interactivityType);

    CmInteractivityLevel getInteractivityLevel();

    void setInteractivityLevel(CmInteractivityLevel interactivityLevel);

    CmCourseSessionModule getModule();

    void setModule(CmCourseSessionModule module);
}
