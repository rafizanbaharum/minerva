package net.canang.minerva.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmCourseSessionImpl implements CmCourseSession {

    private Long id;
    private CmSession session;
    private CmCourse course;
    private List<CmCourseSessionModule> modules;

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
