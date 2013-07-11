package net.canang.minerva.biz.integration;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
public class CmRecord {

    private Long id;
    private String assignee;
    private String candidate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }
}
