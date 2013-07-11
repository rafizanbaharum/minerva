package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmQuizSection extends CmMetaObject{

    String getTitle();

    String getDescription();

    List<CmQuestion> getQuestions();
}
