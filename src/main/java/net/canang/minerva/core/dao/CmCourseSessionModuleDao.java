package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
public interface CmCourseSessionModuleDao {

    // finders

    CmCourseSessionModule findById(Long id);

    CmCourseSessionModule findByOrder(CmCourse course, Integer order);

    CmCourseSessionAssessment findAssessmentById(Long id);

    CmCourseSessionLesson findLessonById(Long id);

    List<CmCourseSessionModule> find(Integer offset, Integer limit);

    List<CmCourseSessionModule> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmCourseSessionModule module, CmUser user);

    void update(CmCourseSessionModule module, CmUser user);

    void deactivate(CmCourseSessionModule module, CmUser user);

    void remove(CmCourseSessionModule module, CmUser user);

    void addLesson(CmCourseSessionModule module, CmCourseSessionLesson lesson, CmUser user);

    void addLessons(CmCourseSessionModule module, List<CmCourseSessionLesson> lesson, CmUser user);

    void updateLesson(CmCourseSessionModule module, CmCourseSessionLesson lesson, CmUser user);

    void updateLessons(CmCourseSessionModule module, List<CmCourseSessionLesson> lesson, CmUser user);

    void removeLesson(CmCourseSessionModule module, CmCourseSessionLesson lesson, CmUser user);

    void removeLessons(CmCourseSessionModule module, List<CmCourseSessionLesson> lesson, CmUser user);

    void addAssessment(CmCourseSessionModule module, CmCourseSessionAssessment assessment, CmUser user);

    void addAssessments(CmCourseSessionModule module, List<? extends CmCourseSessionAssessment> assessments, CmUser user);

    void updateAssessment(CmCourseSessionModule module, CmCourseSessionAssessment assessment, CmUser user);

    void updateAssessments(CmCourseSessionModule module, List<? extends CmCourseSessionAssessment> assessments, CmUser user);

    void removeAssessment(CmCourseSessionModule module, CmCourseSessionAssessment assessment, CmUser user);

    void removeAssessments(CmCourseSessionModule module, List<? extends CmCourseSessionAssessment> assessments, CmUser user);

}
