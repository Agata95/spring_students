package com.javagda25.spring.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo/")
public class IndexController {

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String wyswietlMojaStroneHelloWorldTySpringu() {
        return "strona-hello";
    }

    //    alternatywa dla RequestMapping:
    @GetMapping(path = "/hello")
    public String wyswietlHello() {
        return "strona-hello";
    }

//    klasa Model - przekazuje dane z kontrolera do widoku (na stronę html)
    @GetMapping(path = "/helloTo") // przykład: helloTo?imie=Agata
    public String wyswietlHelloTo(Model model,
                                  @RequestParam(name = "imie", required = false) String parametrImie) {
        model.addAttribute("atrybutImie", parametrImie);

        return "strona-hello-to";
    }

//    drugi sposób przekazania parametru do aplikacji
    @GetMapping("/helloMyBaby/{babyName}") // przykład: helloMyBaby/Agata
    public String wyswietlHelloToBaby(Model model,
                                  @PathVariable(name = "babyName") String variable) {
        model.addAttribute("atrybutImie", variable);

        return "strona-hello-to";
    }
}
