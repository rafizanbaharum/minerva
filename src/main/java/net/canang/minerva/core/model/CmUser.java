package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmUser extends CmPrincipal {

    String getUsername();

    String getRealname();

    String getPassword();

    String getEmail();

}
