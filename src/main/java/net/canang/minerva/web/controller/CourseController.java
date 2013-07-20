package net.canang.minerva.web.controller;

import net.canang.minerva.biz.CatalogFinder;
import net.canang.minerva.biz.integration.markdown.MarkdownProcessor;
import net.canang.minerva.core.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    private Logger log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CatalogFinder finder;

    @Autowired
    private MarkdownProcessor processor;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all(ModelMap model) {
        log.debug("all");
        model.put("courses", decorate(finder.findAll()));
        return "index";
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public String findCourse(@PathVariable String code, ModelMap model) {
        log.debug("findCourse: code " + code);
        model.put("course", decorate(finder.findCourseByCode(code)));
        return "course";
    }

    @RequestMapping(value = "/{code}/module/{order}", method = RequestMethod.GET)
    public String findCourseModule(@PathVariable String code, @PathVariable String order, ModelMap model) {
        log.debug("findCourseModule: code: " + code + "order:" + order);
        CmCourse course = finder.findCourseByCode(code);
        model.put("course", decorate(course));
        model.put("module", decorate(finder.findCourseModuleByOrder(course, Integer.valueOf(order))));
        return "course_module";
    }

    private List<CmCourse> decorate(List<CmCourse> courses) {
        for (CmCourse course : courses) {
            decorate(course);
        }
        return courses;
    }

    private List<CmCourseModule> decorateModule(List<CmCourseModule> modules) {
        for (CmCourseModule module : modules) {
            decorate(module);
        }
        return modules;
    }

    private CmCourse decorate(CmCourse course) {
        try {
            course.setDescription(processor.process(course.getDescription()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return course;
    }

    private CmCourseModule decorate(CmCourseModule module) {
        try {
            module.setDescription(processor.process(module.getDescription()));
            for (CmCourseLesson lesson : module.getLessons()) {
                lesson.setDescription(processor.process(lesson.getDescription()));
                for (CmCourseLessonSection section : lesson.getSections()) {
                    section.setDescription(processor.process(section.getDescription()));
                    for (CmCourseLessonContent content : section.getContents()) {
                        content.setBody(processor.process(content.getBody()));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return module;
    }
}
