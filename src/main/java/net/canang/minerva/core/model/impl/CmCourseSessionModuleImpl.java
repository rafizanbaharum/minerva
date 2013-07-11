package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@Table(name = "CM_COURSE_SESSION_MODULE")
@Entity(name = "CmCourseSessionModule")
public class CmCourseSessionModuleImpl implements CmCourseSessionModule {

    private Long id;
    private String name;
    private String title;
    private String description;
    private String keywords;
    private Integer order;

    private CmCourseSession course;
    private List<CmCourseSessionLesson> lessons;
    private List<CmCourseSessionQuiz> quizzes;

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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public CmCourseSession getCourse() {
        return course;
    }

    public void setCourse(CmCourseSession course) {
        this.course = course;
    }

    public List<CmCourseSessionLesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<CmCourseSessionLesson> lessons) {
        this.lessons = lessons;
    }

    public List<CmCourseSessionQuiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<CmCourseSessionQuiz> quizzes) {
        this.quizzes = quizzes;
    }

    public CmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CmMetadata metadata) {
        this.metadata = metadata;
    }
}
