package ua.com.simplews.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.com.simplews.domain.Person;
import ua.com.simplews.repos.PersonRepo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

//        Iterable<Person> persons = personRepo.findAll();
//        persons.forEach(n -> System.out.println(".///////////...............>>>>>>>>>>" + n.getUsername() + ">roles = " + n.getRoles().size() ));

//        for (Person p : persons) {
//            p.setPassword(passwordEncoder.encode(p.getPassword()));
//            p.setEmail("zopa@mail.sru");
//            personRepo.save(p);
//
//        }

        return "greeting";
    }


    @GetMapping("/login")
    public String login(Map<String, Object> model) {
        return "login";
    }

    @PostMapping("/login")
    public String userLogin(
            @RequestParam String username,
            @RequestParam String password
    ) {


        return "redirect:/";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }


}
