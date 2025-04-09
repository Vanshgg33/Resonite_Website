package com.spring.controller;

import com.spring.Model.Employee;
import com.spring.Model.Student;
import com.spring.Model.Test;
import com.spring.Model.User;
import com.spring.repo.EmployeeRepo;
import com.spring.repo.StudentRepo;
import com.spring.repo.TestRepo;
import com.spring.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private TestRepo testrepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private HttpClient httpClient;
    HttpRequest request;

    @GetMapping("/")
    public String testing() {
        return "ResoniteHome";
    }

    @GetMapping("lol")
    public String te() {
        return "tor";
    }

    @GetMapping("/Regis")
    public String reg() {
        return "Registration";
    }


    @PostMapping("lol")
    public ModelAndView tes(@ModelAttribute Test test) {
//
//    (@RequestParam(name = "name", required = false) String name,
//    @RequestParam(name = "id", required = false) Integer id) {
//        Test test = new Test();
//        test.setName(name);
//        test.setId(id);// Set name from URL parameter

        System.out.println(test.getName());
        testrepo.save(test);

        ModelAndView mv = new ModelAndView();
        mv.addObject("lol", test);
        mv.setViewName("tor"); // Ensure "tor.html" is available
        return mv;
    }

    @PostMapping("save")
    @Transactional
    public ModelAndView RegisterUser(
            @ModelAttribute User user, @ModelAttribute Student student, @ModelAttribute Employee employee) {

        System.out.println(user.getCurrentStatus());
        System.out.println(student.getCourse());
        if (user.getCurrentStatus().equals("student")) {
            user.setStudent(student);
//            userRepo.save(user);
            student.setUser(user);
            studentRepo.save(student);

        } else if (user.getCurrentStatus().equals("employed")) {


            employee.setUser(user);

            employeeRepo.save(employee);
        }
        // Return response
        ModelAndView mv = new ModelAndView();
        mv.addObject("savedUser", user);
        mv.setViewName("SuccessRegis");
        return mv;
    }


}
