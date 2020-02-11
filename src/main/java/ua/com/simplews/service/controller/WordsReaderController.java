package ua.com.simplews.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.simplews.repos.PersonRepo;


@RequestMapping("/loadwords")
@Controller
public class WordsReaderController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Environment env;

    @GetMapping
    public String load(
            @RequestParam String type,
            Model model

    ) {


        System.out.println("spring.servlet.multipart.max-file-size = " + env.getProperty("spring.servlet.multipart.max-file-size"));
        model.addAttribute("info", "Das is Info");

        return "/parts/sw/loadwords";
    }




}
