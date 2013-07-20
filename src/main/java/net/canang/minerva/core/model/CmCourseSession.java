package net.canang.minerva.core.model;

import java.util.List;

/**
 * NOTE: user CmCourseImpl as template
 *
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseSession extends CmMetaObject {

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

    CmSession getSession();

    void setSession(CmSession session);

    CmCourse getCourse();

    void setCourse(CmCourse course);

    List<CmCourseSessionModule> getModules();

    void setModules(List<CmCourseSessionModule> modules);

}
