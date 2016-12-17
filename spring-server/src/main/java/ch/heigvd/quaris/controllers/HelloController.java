package ch.heigvd.quaris.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Fabien Salathe on 14.12.16.
 */
@Controller
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping("/test")
    @ResponseBody
    public String index() {
        return "<h1>Test ok</h1>";
    }
}
