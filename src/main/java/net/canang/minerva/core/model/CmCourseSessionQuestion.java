package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseSessionQuestion extends CmMetaObject{

    String getTitle();

    String getBody();

    List<CmCourseSessionAnswer> getAnswers();

}
