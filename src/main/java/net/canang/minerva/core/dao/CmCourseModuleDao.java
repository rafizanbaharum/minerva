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

    CmCourseModule findByCode(String code);

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

    void addQuiz(CmCourseModule module, CmCourseQuiz quiz, CmUser user);

    void addQuizzes(CmCourseModule module, List<CmCourseQuiz> quiz, CmUser user);

    void updateQuiz(CmCourseModule module, CmCourseQuiz quiz, CmUser user);

    void updateQuizzes(CmCourseModule module, List<CmCourseQuiz> quiz, CmUser user);

    void removeQuiz(CmCourseModule module, CmCourseQuiz quiz, CmUser user);

    void removeQuizzes(CmCourseModule module, List<CmCourseQuiz> quiz, CmUser user);

    void addContent(CmCourseLesson lesson, CmCourseContent content, CmUser user);

    void addContents(CmCourseLesson lesson, List<CmCourseContent> content, CmUser user);

    void updateContent(CmCourseLesson lesson, CmCourseContent content, CmUser user);

    void updateContents(CmCourseLesson lesson, List<CmCourseContent> content, CmUser user);

    void removeContent(CmCourseLesson lesson, CmCourseContent content, CmUser user);

    void removeContents(CmCourseLesson lesson, List<CmCourseContent> content, CmUser user);

}
