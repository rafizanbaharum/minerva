package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmFlowObject extends CmMetaObject {

    CmFlowdata getFlowdata();

    void setFlowdata(CmFlowdata flowdata);
}
