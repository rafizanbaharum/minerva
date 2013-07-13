package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseQuestion extends CmShareable, CmMetaObject {

    String getTitle();

    String getBody();

    List<CmCourseAnswer> getAnswers();

}
