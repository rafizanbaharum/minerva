package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
public interface CmCourseModuleDao {

    // finders

    CmCourseModule findById(Long id);

    CmCourseModule findByOrder(CmCourse course, Integer order);

    CmCourseAssessment findAssessmentById(Long id);

    CmCourseLesson findLessonById(Long id);

    List<CmCourseModule> find(Integer offset, Integer limit);

    List<CmCourseModule> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmCourseModule module, CmUser user);

    void update(CmCourseModule module, CmUser user);

    void deactivate(CmCourseModule module, CmUser user);

    void remove(CmCourseModule module, CmUser user);

    void addLesson(CmCourseModule module, CmCourseLesson lesson, CmUser user);

    void addLessons(CmCourseModule module, List<CmCourseLesson> lesson, CmUser user);

    void updateLesson(CmCourseModule module, CmCourseLesson lesson, CmUser user);

    void updateLessons(CmCourseModule module, List<CmCourseLesson> lesson, CmUser user);

    void removeLesson(CmCourseModule module, CmCourseLesson lesson, CmUser user);

    void removeLessons(CmCourseModule module, List<CmCourseLesson> lesson, CmUser user);

    void addAssessment(CmCourseModule module, CmCourseAssessment assessment, CmUser user);

    void addAssessments(CmCourseModule module, List<? extends CmCourseAssessment> assessments, CmUser user);

    void updateAssessment(CmCourseModule module, CmCourseAssessment assessment, CmUser user);

    void updateAssessments(CmCourseModule module, List<? extends CmCourseAssessment> assessments, CmUser user);

    void removeAssessment(CmCourseModule module, CmCourseAssessment assessment, CmUser user);

    void removeAssessments(CmCourseModule module, List<? extends CmCourseAssessment> assessments, CmUser user);

}
