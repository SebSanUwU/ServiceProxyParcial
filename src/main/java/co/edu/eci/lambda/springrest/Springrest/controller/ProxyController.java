package co.edu.eci.lambda.springrest.Springrest.controller;

import co.edu.eci.lambda.springrest.Springrest.service.RoundRobin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class ProxyController {
    @Autowired
    private RoundRobin roundRobin;
    @GetMapping("/")
    public String getClient(){
        return "index";
    }

    @GetMapping("/robin")
    public ResponseEntity<?> roundRobin(@RequestParam("list") String list, @RequestParam("value") String value,@RequestParam("search") String search){
        try {
            Object response = roundRobin.responseRobin(list,value,search);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
        return ResponseEntity.ok("ok");
    }
}
