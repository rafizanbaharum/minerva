package net.canang.minerva.biz;

import net.canang.minerva.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/14/13
 */
public interface CatalogFinder {

    CmSession findSessionById(Long id);

    CmSession findSessionByCode(String code);

    CmCourse findCourseById(Long id);

    CmCourse findCourseByCode(String code);

    CmCourseModule findCourseModuleById(Long id);

    CmCourseModule findCourseModuleByOrder(CmCourse course, Integer order);

    CmCourseAssessment findCourseAssessmentById(Long id);

    CmCourseLesson findCourseLessonById(Long id);

    List<CmCourse> findAll();
}
