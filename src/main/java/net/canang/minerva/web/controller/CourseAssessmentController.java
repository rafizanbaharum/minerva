package net.canang.minerva.web.controller;

import net.canang.minerva.biz.CatalogFinder;
import net.canang.minerva.biz.integration.markdown.MarkdownProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/course_assessment")
public class CourseAssessmentController {

    private Logger log = LoggerFactory.getLogger(CourseAssessmentController.class);

    @Autowired
    private CatalogFinder finder;

    @Autowired
    private MarkdownProcessor processor;

    @RequestMapping(method = RequestMethod.GET)
    public String find(ModelMap model) {
        log.debug("all");
        return "course_assessment";
    }
}
