package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmMetadata;
import net.canang.minerva.core.model.CmQuiz;
import net.canang.minerva.core.model.CmQuizSection;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmQuizImpl extends CmAssessmentImpl implements CmQuiz {

    private List<CmQuizSection> sections;

    public List<CmQuizSection> getSections() {
        return sections;
    }

    public void setSections(List<CmQuizSection> sections) {
        this.sections = sections;
    }
}
