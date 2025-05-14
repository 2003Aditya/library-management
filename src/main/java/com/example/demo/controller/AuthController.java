//package com.example.demo.controller;
//
//import com.example.demo.model.User;
//import com.example.demo.service.UserService;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class AuthController {
//
//    @Autowired
//    private UserService userService;
//
//    // Show the login page
//    @GetMapping("/login")
//    public String showLoginPage() {
//        return "login";
//    }
//
//    // Handle login form submission
//    //@PostMapping("/login")
//    //public String login(@RequestParam String username,
//    //                    @RequestParam String password,
//    //                    HttpSession session,
//    //                    Model model) {
//    //    User user = userService.findByUsername(username);
//    //    if (user != null && user.getPassword().equals(password)) {
//    //        session.setAttribute("user", user);
//    //        return "redirect:/books";
//    //    } else {
//    //        model.addAttribute("error", "Invalid username or password");
//    //        return "login";
//    //    }
//    //}
//
//    // Handle logout and invalidate session
//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//        session.invalidate();
//        return "redirect:/login";
//    }
//
//    // Redirect root path to login page
//    @GetMapping("/")
//    public String redirectToLogin() {
//        return "redirect:/login";
//    }
//}
//


package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/")
    public String redirectToBooks() {
        return "redirect:/books";
    }
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

}

