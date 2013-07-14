package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_CORS_ASST")
@Entity(name = "CmCourseAsset")
public class CmCourseAssetImpl implements CmCourseAsset {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_ASST")
    @SequenceGenerator(name = "SEQ_CM_CORS_ASST", sequenceName = "SEQ_CM_CORS_ASST", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "KEYWORDS")
    private String keywords;

    @Column(name = "PATH")
    private String path;

    @OneToOne(targetEntity = CmCourseImpl.class)
    @JoinColumn(name = "COURSE_ID")
    private CmCourse course;

    @Embedded
    private CmMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public CmCourse getCourse() {
        return course;
    }

    public void setCourse(CmCourse course) {
        this.course = course;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
