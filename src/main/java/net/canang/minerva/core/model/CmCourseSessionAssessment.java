package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseSessionAssessment extends CmMetaObject {

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    Integer getWeight();

    void setWeight(Integer weight);

    boolean isSectionShown();

    void setSectionShown(boolean sectionShown);

    Integer getOrder();

    void setOrder(Integer order);

    CmCourseAssessmentType getAssessmentType();

    void setAssessmentType(CmCourseAssessmentType assemenAssessmentType);

    CmCourseSessionModule getModule();

    void setModule(CmCourseSessionModule module);

}
