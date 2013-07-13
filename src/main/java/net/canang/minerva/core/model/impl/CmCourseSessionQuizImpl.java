package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
@Table(name = "CM_CORS_SESN_QUIZ")
@Entity(name = "CmCourseSessionQuiz")
public class CmCourseSessionQuizImpl implements CmCourseSessionQuiz {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_SESN_QUIZ")
    @SequenceGenerator(name = "SEQ_CM_CORS_SESN_QUIZ", sequenceName = "SEQ_CM_CORS_SESN_QUIZ", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne(targetEntity = CmCourseSessionModuleImpl.class)
    @JoinColumn(name = "MODULE_ID")
    private CmCourseSessionModule module;

    @OneToMany(targetEntity = CmCourseSessionQuizSectionImpl.class, mappedBy = "quiz")
    private List<CmCourseSessionQuizSection> sections;


    @Embedded
    private CmMetadata metadata = new CmMetadata();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CmCourseSessionModule getModule() {
        return module;
    }

    public void setModule(CmCourseSessionModule module) {
        this.module = module;
    }

    public List<CmCourseSessionQuizSection> getSections() {
        return sections;
    }

    public void setSections(List<CmCourseSessionQuizSection> sections) {
        this.sections = sections;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
