package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public interface CmCourseSessionDiscussion extends CmMetaObject{

    List<CmCourseSessionMessage> getMessages();

    void setMessages(List<CmCourseSessionMessage> messages);

}
