package net.canang.minerva.biz;

import net.canang.minerva.biz.config.CmBizConfig;
import net.canang.minerva.biz.integration.markdown.AssetPlugin;
import net.canang.minerva.biz.integration.markdown.MarkdownProcessor;
import net.canang.minerva.core.dao.CmUserDao;
import net.canang.minerva.core.model.*;
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
public class CatalogFinderTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(CatalogFinderTest.class);

    @Autowired
    private CmUserDao userDao;

    @Autowired
    private CatalogFinder finder;

    @Autowired
    private MarkdownProcessor processor;

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
    public void testContent() {
        try {
            List<CmCourse> all = finder.findAll();
            for (CmCourse course : all) {
                log.debug(course.getDescription());
                log.debug(new Markdown4jProcessor().registerPlugins(new AssetPlugin()).process(course.getDescription()));
            }
        } catch (IOException e) {
            log.error("error", e);
        }
    }
}
