package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmActorProfile extends CmMetaObject {

    CmActor getActor();

    void setActor(CmActor actor);

    CmActorAttribute getAttribute();

    void setAttribute(CmActorAttribute attribute);

    String getValue();

    void setValue(String value);
}
