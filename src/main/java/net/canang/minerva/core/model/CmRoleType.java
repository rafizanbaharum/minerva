package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
public enum CmRoleType {

    ROLE_ADMINISTRATOR("Administrator"),
    ROLE_USER("User"),
    ROLE_GUEST("Guest");

    private String description;

    CmRoleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
