package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface CmCourseAsset extends CmMetaObject {

    String getName();

    void setName(String name);

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    String getKeywords();

    void setKeywords(String keywords);

    String getPath();

    void setPath(String path);
}
