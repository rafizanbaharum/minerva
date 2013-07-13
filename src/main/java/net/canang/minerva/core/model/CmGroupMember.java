package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmGroupMember extends CmMetaObject {

    CmGroup getGroup();

    void setGroup(CmGroup group);

    CmPrincipal getMember();

    void setMember(CmPrincipal member);
}
