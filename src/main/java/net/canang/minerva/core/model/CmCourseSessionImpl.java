package net.canang.minerva.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmCourseSessionImpl implements CmCourseSession {

    private Long id;
    private CmSession session;
    private CmMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CmSession getSession() {
        return session;
    }

    public void setSession(CmSession session) {
        this.session = session;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
