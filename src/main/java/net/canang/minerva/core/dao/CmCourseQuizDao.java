package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.CmCourseQuestion;
import net.canang.minerva.core.model.CmCourseQuiz;
import net.canang.minerva.core.model.CmCourseQuizSection;
import net.canang.minerva.core.model.CmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
public interface CmCourseQuizDao {

    // finders

    CmCourseQuiz findById(Long id);

    CmCourseQuiz findByCode(String code);

    List<CmCourseQuiz> find(Integer offset, Integer limit);

    List<CmCourseQuiz> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmCourseQuiz quiz, CmUser user);

    void update(CmCourseQuiz quiz, CmUser user);

    void deactivate(CmCourseQuiz quiz, CmUser user);

    void remove(CmCourseQuiz quiz, CmUser user);

    void addSection(CmCourseQuiz quiz, CmCourseQuizSection section, CmUser user);

    void addSections(CmCourseQuiz quiz, List<CmCourseQuizSection> sections, CmUser user);

    void updateSection(CmCourseQuiz quiz, CmCourseQuizSection section, CmUser user);

    void updateSections(CmCourseQuiz quiz, List<CmCourseQuizSection> sections, CmUser user);

    void removeSection(CmCourseQuiz quiz, CmCourseQuizSection section, CmUser user);

    void removeSections(CmCourseQuiz quiz, List<CmCourseQuizSection> sections, CmUser user);

    void addQuestion(CmCourseQuizSection section, CmCourseQuestion question, CmUser user);

    void addQuestions(CmCourseQuizSection section, List<CmCourseQuestion> questions, CmUser user);

    void updateQuestion(CmCourseQuizSection section, CmCourseQuestion question, CmUser user);

    void updateQuestions(CmCourseQuizSection section, List<CmCourseQuestion> questions, CmUser user);

    void removeQuestion(CmCourseQuizSection section, CmCourseQuestion question, CmUser user);

    void removeQuestions(CmCourseQuizSection section, List<CmCourseQuestion> questions, CmUser user);

}
