package dev.byteschool.byteschoolapp.health;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/status")
public class StatusController {

    @GetMapping
    String getStatus(){
        return "OK";
    }
}
