package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.CmCourseSessionAnswer;
import net.canang.minerva.core.model.CmMetadata;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_COURSE_SESSION_ANSWER")
@Entity(name = "CmCourseSessionAnswer")
public class CmCourseSessionAnswerImpl implements CmCourseSessionAnswer {

    private Long id;
    private String text;
    private Integer order;
    private boolean answer;

    private CmMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
