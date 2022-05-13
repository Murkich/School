package com.Golub.school.Controller;

import com.Golub.school.entity.*;
import com.Golub.school.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private static String path = "usersTemplates/";
    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @Autowired
    AdminService adminService;

    @Autowired
    MentorService mentorService;

    @Autowired
    CardService cardService;

    //Данные пользователя
    @RequestMapping(value = "/area", method = RequestMethod.GET)
    public String showUserArea(Model model) {
        User user = userService.userBySecurityContext();

        model.addAttribute("users", user);
        model.addAttribute("students", studentService.findStudentByIduser(user.getIduser()));
        model.addAttribute("mentors", mentorService.findMentorByIduser(user.getIduser()));
        model.addAttribute("admins", adminService.findAdminByIduser(user.getIduser()));
        return path + "userArea";
    }

    //Редактирование инфы - страница
    @RequestMapping(value = "/area/edit/{id}", method = RequestMethod.GET)
    public String userAreaInformEdit(@PathVariable int id, Model model) {
        model.addAttribute("users", userService.findUserById(id));
        model.addAttribute("students", studentService.findStudentByIduser(id));
        model.addAttribute("admins", adminService.findAdminByIduser(id));
        model.addAttribute("mentors", mentorService.findMentorByIduser(id));

        return path + "UserEdit";
    }

    //Сохранение редактирование инфы о себе
    @RequestMapping(value = "/area/edit", method = RequestMethod.POST)
    public String saveUserAreaInformEdit(@RequestParam int id, User user,
                                         @RequestParam String surname,
                                         @RequestParam String name,
                                         @RequestParam String number,
                                         @RequestParam String email) {
        userService.saveUser(user);
        if (user.getStatus().equals("user")) {
            Students students = studentService.findStudentByIduser(id);
            students.setSurname(surname);
            students.setName(name);
            students.setNumber(number);
            students.setEmail(email);
            studentService.saveStudents(students);
        }
        if (user.getStatus().equals("admin")) {
            Admin admin = adminService.findAdminByIduser(id);
            admin.setSurname(surname);
            admin.setName(name);
            admin.setNumber(number);
            admin.setEmail(email);
            adminService.saveAdmin(admin);
        }
        if (user.getStatus().equals("mentor")) {
            Mentor mentor = mentorService.findMentorByIduser(id);
            mentor.setSurname(surname);
            mentor.setName(name);
            mentor.setNumber(number);
            mentor.setEmail(email);
            mentorService.saveMentor(mentor);
        }
        return "redirect:/user/area";
    }

    //Вывод всех пользователей
    @GetMapping
    public String showUserActionPage(Model model) {
        model.addAttribute("users", userService.findAll());
        return path + "userAction";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findUser(@RequestParam (required = false) String surname,
                           Model model) {
        model.addAttribute("users", studentService.findStudentsBySurname(surname));
        model.addAttribute("admins", adminService.findAdminBySurname(surname));
        model.addAttribute("mentor", mentorService.findMentorBySurname(surname));
        return path + "userAction";
    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    public String userBalanceInform(Students students, Model model) {
        model.addAttribute("card", cardService.findCardByIdstudent(students.getIdstudents()));

        return path + "userBalance";
    }

    @RequestMapping(value = "/balanceCheck", method = RequestMethod.GET)
    public String userBalanceCheck(Model model) {
        return path + "userBalanceCheck";
    }

    @RequestMapping(value = "/materials", method = RequestMethod.GET)
    public String userMaterials(Model model) {
        return path + "materials";
    }

    //Редактирование роли
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@RequestParam int id,
                           @RequestParam String button,
                           @RequestParam String active,
                           Model model) {
        if (button.equals("up")) {
            userService.editUserRole("admin", id);
        }
        if (button.equals("dowm")) {
            userService.editUserRole("user", id);
        }
        if (button.equals("block")) {
            userService.editUserActive(false, id);
        }
        if (button.equals("unblock")) {
            userService.editUserActive(true, id);
        }
        return "redirect:/user";
    }

    //Регистрация
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String regUser(@Valid User user,
                          BindingResult bindingResult,
                          @Valid Students students,
                          BindingResult bindingResult1,
                          Model model) {
        if (bindingResult.hasErrors()||bindingResult1.hasErrors()) {
            Map<String,String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            errorsMap = ControllerUtils.getErrors(bindingResult1);
            model.mergeAttributes(errorsMap);
            model.addAttribute("user", user);
            model.addAttribute("students", students);
            return "reg";
        }
        else {
            user.setStatus("user");
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.valueOf("user")));
            userService.saveUser(user);
            studentService.addStudent(students);
        }
        return "request";
    }
}
