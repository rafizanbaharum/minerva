package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseSessionMessage extends CmMetaObject{

    CmCourseSessionDiscussion getDiscussion();

    void setDiscusssion(CmCourseSessionDiscussion discusssion);
}
