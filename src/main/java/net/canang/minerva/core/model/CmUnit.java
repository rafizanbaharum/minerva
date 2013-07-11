package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmUnit {

    String getCode();

    String getAlias();

    String getDescription();

    CmDepartment getDepartment();
}
