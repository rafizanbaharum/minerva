package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public class CmQuestionImpl implements CmQuestion {

    private Long id;
    private String title;
    private String body;
    private List<CmAnswer> answers;

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

    public List<CmAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<CmAnswer> answers) {
        this.answers = answers;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
