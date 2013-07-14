package net.canang.minerva.core.model.impl;

import net.canang.minerva.core.model.*;

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

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "KEYWORDS")
    private String keywords;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "DIFFICULTY")
    private CmDifficulty difficulty;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "INTERACTIVITY_TYPE")
    private CmInteractivityType interactivityType;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "INTERACTIVITY_LEVEL")
    private CmInteractivityLevel interactivityLevel;

    @OneToOne(targetEntity = CmDepartmentImpl.class)
    @JoinColumn(name = "DEPARTMENT_ID")
    private CmDepartment department;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public CmDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(CmDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public CmInteractivityType getInteractivityType() {
        return interactivityType;
    }

    public void setInteractivityType(CmInteractivityType interactivityType) {
        this.interactivityType = interactivityType;
    }

    public CmInteractivityLevel getInteractivityLevel() {
        return interactivityLevel;
    }

    public void setInteractivityLevel(CmInteractivityLevel interactivityLevel) {
        this.interactivityLevel = interactivityLevel;
    }

    public CmDepartment getDepartment() {
        return department;
    }

    public void setDepartment(CmDepartment department) {
        this.department = department;
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
