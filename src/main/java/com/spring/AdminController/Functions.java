package com.spring.AdminController;

import com.spring.Model.Course_Fees_INFO;
import com.spring.Model.Employee;
import com.spring.Model.Student;
import com.spring.Model.User;
import com.spring.repo.EmployeeRepo;
import com.spring.repo.FeesRepo;
import com.spring.repo.StudentRepo;
import com.spring.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class Functions {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FeesRepo feesRepo;
    User userUniversal;


    @GetMapping("/payments")
    public ModelAndView paymentinfo() {
        List<User> users = userRepo.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("users", users);
        mv.setViewName("SelectUserPayment");
        System.out.println(users);
        return mv;
    }

    @GetMapping("/allusers")
    public ModelAndView getall() {
        List<Student> students = studentRepo.findAllStudentsWithUser();
        List<Employee> employees = employeeRepo.findallemployeewithuser();
        ModelAndView mv = new ModelAndView();
        mv.addObject("students", students);
        mv.addObject("employees", employees);
        mv.setViewName("AllUsers");
        return mv;

    }

    double totalfee;
    double remaining;
    String name;
    String coursname;


    @PostMapping("forExsist")
    public ModelAndView decide(@ModelAttribute Course_Fees_INFO courseFeesInfo){
      courseFeesInfo.setCourseName(coursname);
      courseFeesInfo.setName(name);
      courseFeesInfo = feesRepo.save(courseFeesInfo);
      ModelAndView mv = new ModelAndView();

     return new ModelAndView("redirect:/searchUser");
    }


    @PostMapping("/searchUser")
    public ModelAndView searchUser(@RequestParam("userId") int id,@ModelAttribute Course_Fees_INFO courseFeesInfo) {
         System.out.println("i am here");

        User user = new User();
        user = userRepo.getById(id);
        name = user.getName();
        System.out.println(name);
        coursname = user.getCourseInterest();
        ModelAndView mv = new ModelAndView();
        mv.addObject("id", id);
        if (feesRepo.existsByName(name) ) {
          courseFeesInfo.setName(name);
          courseFeesInfo.setCourseName(coursname);

            System.out.println("Yes it exsist");
            List<Course_Fees_INFO> cr = feesRepo.getByName(name);
            for (Course_Fees_INFO item : cr) {
                System.out.println("Fee ID: " + item.getFeeId());
                System.out.println("User Name: " + item.getName());
                System.out.println("Course Name: " + item.getCourseName());
                System.out.println("Total Fees: " + item.getTotal_Fees());
                System.out.println("Date Paid: " + item.getDatePaid());
                System.out.println("Fee Paid: " + item.getFeePaid());
                System.out.println("Remaining Fees: " + item.getRemainingFees());
                System.out.println("----------------------");

            }

            mv.addObject("cr", cr);
            mv.addObject("remaining",remaining);
          //  courseFeesInfo= feesRepo.save(courseFeesInfo);
            mv.setViewName("UpdatePay2");

        } else {
            courseFeesInfo.setName(user.getName());
            courseFeesInfo.setCourseName(user.getCourseInterest());
            System.out.println(courseFeesInfo.getName());
            mv.addObject("totalfee", totalfee);
//            Course_Fees_INFO courseFeesInfo1=feesRepo.save(courseFeesInfo);
            mv.addObject("user", user);
            mv.setViewName("UpdatePay1");

        }
        return mv;
    }



    @PostMapping("/updateFee")
    public ModelAndView feeup(@ModelAttribute Course_Fees_INFO courseFeesInfo) {

//       courseFeesInfo.setUser(user);
        courseFeesInfo.setName(name);
        courseFeesInfo.setCourseName(coursname);
        feesRepo.save(courseFeesInfo);

        List<Course_Fees_INFO> fessinfo = feesRepo.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("fessinfo", fessinfo);
        System.out.println(courseFeesInfo.getName());
        mv.setViewName("updatedFee0");

        return mv;
    }
}
