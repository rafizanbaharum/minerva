package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmAssessment;
import net.canang.minerva.core.model.CmMetadata;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_ASMT")
@Entity(name = "CmAssessment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CmAssessmentImpl implements CmAssessment {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_ASMT")
    @SequenceGenerator(name = "SEQ_CM_ASMT", sequenceName = "SEQ_CM_ASMT", allocationSize = 1)
    private Long id;

    @Embedded
    private CmMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
