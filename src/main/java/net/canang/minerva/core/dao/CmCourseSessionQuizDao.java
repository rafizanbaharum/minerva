package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmCourseSessionQuiz;
import net.canang.minerva.core.model.CmCourseSessionQuizQuestion;
import net.canang.minerva.core.model.CmCourseSessionQuizSection;
import net.canang.minerva.core.model.CmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
public interface CmCourseSessionQuizDao {

    // finders

    CmCourseSessionQuiz findById(Long id);

    CmCourseSessionQuiz findByCode(String code);

    List<CmCourseSessionQuiz> find(Integer offset, Integer limit);

    List<CmCourseSessionQuiz> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmCourseSessionQuiz quiz, CmUser user);

    void update(CmCourseSessionQuiz quiz, CmUser user);

    void deactivate(CmCourseSessionQuiz quiz, CmUser user);

    void remove(CmCourseSessionQuiz quiz, CmUser user);

    void addSection(CmCourseSessionQuiz quiz, CmCourseSessionQuizSection section, CmUser user);

    void addSections(CmCourseSessionQuiz quiz, List<CmCourseSessionQuizSection> sections, CmUser user);

    void updateSection(CmCourseSessionQuiz quiz, CmCourseSessionQuizSection section, CmUser user);

    void updateSections(CmCourseSessionQuiz quiz, List<CmCourseSessionQuizSection> sections, CmUser user);

    void removeSection(CmCourseSessionQuiz quiz, CmCourseSessionQuizSection section, CmUser user);

    void removeSections(CmCourseSessionQuiz quiz, List<CmCourseSessionQuizSection> sections, CmUser user);

    void addQuestion(CmCourseSessionQuizSection section, CmCourseSessionQuizQuestion question, CmUser user);

    void addQuestions(CmCourseSessionQuizSection section, List<? extends CmCourseSessionQuizQuestion> questions, CmUser user);

    void updateQuestion(CmCourseSessionQuizSection section, CmCourseSessionQuizQuestion question, CmUser user);

    void updateQuestions(CmCourseSessionQuizSection section, List<? extends CmCourseSessionQuizQuestion> questions, CmUser user);

    void removeQuestion(CmCourseSessionQuizSection section, CmCourseSessionQuizQuestion question, CmUser user);

    void removeQuestions(CmCourseSessionQuizSection section, List<? extends CmCourseSessionQuizQuestion> questions, CmUser user);

}
