package net.canang.minerva.core;

import net.canang.minerva.core.config.CmCoreConfig;
import net.canang.minerva.core.dao.CmCourseSessionDao;
import net.canang.minerva.core.dao.CmUserDao;
import net.canang.minerva.core.model.CmCourseSession;
import net.canang.minerva.core.model.impl.CmCourseSessionImpl;
import net.canang.minerva.core.model.CmUser;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CmCoreConfig.class})
public class CmCourseSessionDaoTest {

    private Logger log = LoggerFactory.getLogger(CmCourseSessionDaoTest.class);

    @Autowired
    private CmCourseSessionDao courseSessionDao;

    @Autowired
    private CmUserDao userDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void createCourse() {
        CmUser root = userDao.findByUsername("root");

        CmCourseSession courseSession = new CmCourseSessionImpl();
        courseSessionDao.save(courseSession, root);

    }
}
