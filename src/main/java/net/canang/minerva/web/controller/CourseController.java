package net.canang.minerva.web.controller;

import net.canang.minerva.biz.CatalogFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/course")
public class CourseController {

    private Logger log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CatalogFinder finder;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all(ModelMap model) {
        log.debug("all");
        model.put("courses", finder.findAll());
        return "index";
    }
}
