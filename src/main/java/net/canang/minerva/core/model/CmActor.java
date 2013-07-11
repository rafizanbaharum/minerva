package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmActor extends CmMetaObject {

    String getName();

    String getEmail();

    String getAddress1();

    String getAddress2();

    String getAddress3();

    String getPhone();

    String getFax();

    CmActorType getActorType();

}
