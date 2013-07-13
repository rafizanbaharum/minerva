package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmDocument;
import net.canang.minerva.core.model.CmFlowdata;
import net.canang.minerva.core.model.CmMetadata;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_DOCM")
@Entity(name = "CmDocument")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CmDocumentImpl implements CmDocument {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_DOCM")
    @SequenceGenerator(name = "SEQ_CM_DOCM", sequenceName = "SEQ_CM_DOCM", allocationSize = 1)
    private Long id;

    @Column(name = "REFERENCE_NO")
    private String referenceNo;

    @Column(name = "SOURCE_NO")
    private String sourceNo;

    @Embedded
    private CmMetadata metadata;

    @Embedded
    private CmFlowdata flowdata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }

    public CmFlowdata getFlowdata() {
        return flowdata;
    }

    public void setFlowdata(CmFlowdata flowdata) {
        this.flowdata = flowdata;
    }
}
