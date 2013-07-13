package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmUser extends CmPrincipal {

    String getUsername();

    void setUsername(String username);

    String getRealname();

    void setRealname(String realname);

    String getPassword();

    void setPassword(String password);

    String getEmail();

    void setEmail(String email);

    CmActor getActor();

    void setActor(CmActor actor);

}
