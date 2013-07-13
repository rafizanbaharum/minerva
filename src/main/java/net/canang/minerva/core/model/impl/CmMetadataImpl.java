package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmMetaState;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Embeddable
public class CmMetadataImpl {

    @Column(name = "C_ID")
    private Long creator;

    @Column(name = "C_TS")
    private Date createdDate;

    @Column(name = "M_ID")
    private Long modifier;

    @Column(name = "M_TS")
    private Date modifiedDate;

    @Column(name = "D_ID")
    private Long deleter;

    @Column(name = "D_TS")
    private Date deletedDate;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "M_ST")
    private CmMetaState state;

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getDeleter() {
        return deleter;
    }

    public void setDeleter(Long deleter) {
        this.deleter = deleter;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public CmMetaState getState() {
        return state;
    }

    public void setState(CmMetaState state) {
        this.state = state;
    }
}
