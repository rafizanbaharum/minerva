package net.canang.minerva.biz.impl;

import net.canang.minerva.biz.CatalogFinder;
import net.canang.minerva.core.dao.CmCourseDao;
import net.canang.minerva.core.dao.CmCourseModuleDao;
import net.canang.minerva.core.dao.CmSessionDao;
import net.canang.minerva.core.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/14/13
 */
@Component("catalogFinder")
public class CatalogFinderImpl implements CatalogFinder {

    private Logger log = LoggerFactory.getLogger(CatalogFinderImpl.class);

    @Autowired
    private CmSessionDao sessionDao;

    @Autowired
    private CmCourseDao courseDao;

    @Autowired
    private CmCourseModuleDao courseModuleDao;

    @Override
    public CmSession findSessionById(Long id) {
        return sessionDao.findById(id);
    }

    @Override
    public CmSession findSessionByCode(String code) {
        return sessionDao.findByCode(code);
    }

    @Override
    public CmCourse findCourseById(Long id) {
        return courseDao.findById(id);
    }

    @Override
    public CmCourse findCourseByCode(String code) {
        return courseDao.findByCode(code);
    }

    @Override
    public CmCourseModule findCourseModuleById(Long id) {
        return courseModuleDao.findById(id);
    }

    @Override
    public CmCourseModule findCourseModuleByOrder(CmCourse course, Integer order) {
        return courseModuleDao.findByOrder(course, order);
    }

    @Override
    public CmCourseAssessment findCourseAssessmentById(Long id) {
        return courseModuleDao.findAssessmentById(id);
    }

    @Override
    public CmCourseLesson findCourseLessonById(Long id) {
        return courseModuleDao.findLessonById(id);
    }

    @Override
    public List<CmCourse> findAll() {
        return courseDao.find(0, 100);
    }
}
