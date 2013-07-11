package net.canang.minerva.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmMetadata {

    Long getCreator();

    void setCreator(Long id);

    Date getCreatedDate();

    void setCreatedDate(Date createdDate);

    Long getModifier();

    void setModifier(Long modifier);

    Date getModifiedDate();

    void setModifiedDate(Date modifiedDate);

    Long getDeleter();

    void setDeleter(Long deleter);

    Date getDeletedDate();

    void setDeletedDate(Date deletedDate);

    CmMetaState getState();

    void setState(CmMetaState state);

}
