package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmActorProfile extends CmMetaObject {

    CmActor getActor();

    CmActorAttribute getAttribute();

    String getValue();
}
