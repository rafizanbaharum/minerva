package net.canang.minerva.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmMetadata {

    Long getCreator();

    Date getCreatedDate();

    Long getModifier();

    Date getModifiedDate();

    Long getDeleter();

    Date getDeletedDate();

    CmMetaState getState();
}
