package net.canang.minerva.biz.event;

import net.canang.minerva.core.model.CmFlowObject;
import org.springframework.context.ApplicationEvent;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public class ProcessEvent extends ApplicationEvent {

    private CmFlowObject flowObject;

    public ProcessEvent(CmFlowObject flowObject) {
        super(flowObject);
        this.flowObject = flowObject;
    }

    public CmFlowObject getFlowObject() {
        return flowObject;
    }

    public void setFlowObject(CmFlowObject flowObject) {
        this.flowObject = flowObject;
    }
}
