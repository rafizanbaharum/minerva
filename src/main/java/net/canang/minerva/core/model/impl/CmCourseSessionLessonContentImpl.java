package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseSessionLessonContent;
import net.canang.minerva.core.model.CmCourseSessionLessonSection;
import net.canang.minerva.core.model.CmMetadata;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_CORS_SESN_LSSN_CNTN")
@Entity(name = "CmCourseSessionLessonContent")
public class CmCourseSessionLessonContentImpl implements CmCourseSessionLessonContent {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_SESN_LSSN_CNTN")
    @SequenceGenerator(name = "SEQ_CM_CORS_SESN_LSSN_CNTN", sequenceName = "SEQ_CM_CORS_SESN_LSSN_CNTN", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Lob
    @Column(name = "BODY")
    private String body;

    @Column(name = "ORDR")
    private Integer order;

    @OneToOne(targetEntity = CmCourseSessionLessonSectionImpl.class)
    @JoinColumn(name = "SECTION_ID")
    private CmCourseSessionLessonSection section;

    @Embedded
    private CmMetadata metadata;


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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public CmCourseSessionLessonSection getSection() {
        return section;
    }

    public void setSection(CmCourseSessionLessonSection section) {
        this.section = section;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
