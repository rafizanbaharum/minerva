package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmAssessment;
import net.canang.minerva.core.model.CmMetadata;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmAssessmentImpl implements CmAssessment {

    private Long id;
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
