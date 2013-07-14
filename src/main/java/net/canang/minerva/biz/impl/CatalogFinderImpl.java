package net.canang.minerva.biz.impl;

import net.canang.minerva.biz.CatalogFinder;
import net.canang.minerva.core.dao.CmCourseDao;
import net.canang.minerva.core.model.CmCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/14/13
 */
@Component("catalogFinder")
public class CatalogFinderImpl implements CatalogFinder {

    @Autowired
    private CmCourseDao courseDao;

    @Override
    public List<CmCourse> findAll() {
        return courseDao.find(0, 100);
    }
}
