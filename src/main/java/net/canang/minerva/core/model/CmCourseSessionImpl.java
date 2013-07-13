package net.canang.minerva.core.model;

import net.canang.minerva.core.model.impl.CmCourseImpl;
import net.canang.minerva.core.model.impl.CmCourseSessionModuleImpl;
import net.canang.minerva.core.model.impl.CmSessionImpl;

import javax.persistence.*;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_CORS_SESN")
@Entity(name = "CmCourseSession")
public class CmCourseSessionImpl implements CmCourseSession {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_CM_CORS_SESN")
    @SequenceGenerator(name = "SEQ_CM_CORS_SESN", sequenceName = "SEQ_CM_CORS_SESN", allocationSize = 1)
    private Long id;


    @OneToOne(targetEntity = CmSessionImpl.class)
    @JoinColumn(name = "SESSION_ID")
    private CmSession session;

    @OneToOne(targetEntity = CmCourseImpl.class)
    @JoinColumn(name = "COURSE_ID")
    private CmCourse course;

    @OneToMany(targetEntity = CmCourseSessionModuleImpl.class, mappedBy = "course")
    private List<CmCourseSessionModule> modules;

    @Embedded
    private CmMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CmCourse getCourse() {
        return course;
    }

    public void setCourse(CmCourse course) {
        this.course = course;
    }

    public CmSession getSession() {
        return session;
    }

    public void setSession(CmSession session) {
        this.session = session;
    }

    public List<CmCourseSessionModule> getModules() {
        return modules;
    }

    public void setModules(List<CmCourseSessionModule> modules) {
        this.modules = modules;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
