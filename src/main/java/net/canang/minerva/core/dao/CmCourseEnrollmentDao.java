package net.canang.minerva.core.dao;

import net.canang.minerva.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/13/13
 */
public interface CmCourseEnrollmentDao {

    // finders

    CmCourseEnrollment findById(Long id);

    CmCourseEnrollment findByCode(String code);

    List<CmCourseEnrollment> find(Integer offset, Integer limit);

    List<CmCourseEnrollment> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    // cruds

    void save(CmCourseEnrollment enrollment, CmUser user);

    void update(CmCourseEnrollment enrollment, CmUser user);

    void deactivate(CmCourseEnrollment enrollment, CmUser user);

    void remove(CmCourseEnrollment enrollment, CmUser user);

}
