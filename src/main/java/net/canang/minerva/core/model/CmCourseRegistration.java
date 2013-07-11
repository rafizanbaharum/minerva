package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseRegistration extends CmFlowObject {

    CmSession getSession();

    CmCourse getCourse();

    CmStudent getStudent();

    boolean isRequired();
}
