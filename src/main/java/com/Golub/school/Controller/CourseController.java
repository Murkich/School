package com.Golub.school.Controller;

import com.Golub.school.entity.Course;
import com.Golub.school.entity.Students;
import com.Golub.school.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Map;


@Controller
@RequestMapping("/request")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping()
    public String showCourseActionPage(Model model) {
        model.addAttribute("courses", courseService.getAllCourse());
        return "request";
    }

    //Поиск
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findRequestByName(@RequestParam String findRequest_name, Model model) {
        model.addAttribute("courses", courseService.findByName(findRequest_name));
        return "request";
    }

    //Фильтры
    //Английский
    @RequestMapping(value = "/eng", method = RequestMethod.GET)
    public String showEngCourse(Model model) {
        model.addAttribute("courses", courseService.findAllByLanguage("Английский"));
        return "request";
    }

    //Немецкий
    @RequestMapping(value = "/germ", method = RequestMethod.GET)
    public String showGermCourse(Model model) {
        model.addAttribute("courses", courseService.findAllByLanguage("Немецкий"));
        return "request";
    }

    //Французский
    @RequestMapping(value = "/franch", method = RequestMethod.GET)
    public String showFranchCourse(Model model) {
        model.addAttribute("courses", courseService.findAllByLanguage("Французский"));
        return "request";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddCoursePage() {
        return "requestAdd";
    }

    //Добавление курса
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCourse(@Valid Course course,
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            return "requestAdd";
       } else {
            courseService.save(course);
            return "redirect:/request";
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditCoursePage() {
        return "requestEdit";
    }

    //Редактирование курса
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editCourse(@PathVariable int id, Course course) {
        courseService.edit(course, id);
        return "request";
    }

    //Удаление курса
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteCourse(@PathVariable int id, Course course) {
        courseService.delete(course, id);
        return "request";
    }

    //Забронировать
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String OrderCourse(@PathVariable int id, Course course, Students student) {
        course.getStudents().add(student);
        return "request";
    }

    //Показ бронированных курсов
    @RequestMapping(value = "/mycourse", method = RequestMethod.GET)
    public String showUserCoursePage() {
        return "userCourse";
    }

    //Отменить бронь
    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.GET)
    public String CancelCourse(@PathVariable int id, Course course, Students student) {
        course.getStudents().remove(student);
        return "request";
    }
}
