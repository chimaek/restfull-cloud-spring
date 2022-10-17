package net.chimaek.restful_msa.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {


    @GetMapping("/main")
    public String main() {
        return "main";
    }

}
