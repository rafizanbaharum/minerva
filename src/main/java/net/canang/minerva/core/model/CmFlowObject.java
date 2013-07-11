package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmFlowObject extends CmMetaObject {

    String getReferenceNo();

    String getSourceNo();

    CmFlowdata getFlowdata();
}
