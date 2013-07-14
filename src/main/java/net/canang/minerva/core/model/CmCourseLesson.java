package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseLesson extends CmMetaObject {

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

    CmCourseModule getModule();

    void setModule(CmCourseModule module);

    List<CmCourseContent> getContents();

    void setContents(List<CmCourseContent> contents);

}
