package net.canang.minerva.biz;

import net.canang.minerva.biz.config.CmBizConfig;
import net.canang.minerva.biz.integration.markdown.AssetPlugin;
import net.canang.minerva.biz.integration.markdown.MarkdownProcessor;
import net.canang.minerva.core.dao.CmUserDao;
import net.canang.minerva.core.model.CmCourse;
import net.canang.minerva.core.model.CmSession;
import net.canang.minerva.core.model.CmUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.markdown4j.Markdown4jProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 7/11/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CmBizConfig.class})
public class SessionManagerTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(SessionManagerTest.class);

    @Autowired
    private CmUserDao userDao;

    @Autowired
    private CatalogFinder finder;

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    private CmUser root;

    @Before
    public void setUp() {
        log.debug("logging in user");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("root", "abc123");
        Authentication authed = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authed);
        root = userDao.findByUsername("root");
    }

    @Test
    @Rollback(value = false)
    public void testCreateCourseSession() {
        CmCourse course = finder.findCourseByCode("CS101");
        CmSession session = finder.findSessionByCode("F2013");
        sessionManager.serializeToCourseSession(session, course);
    }
}
