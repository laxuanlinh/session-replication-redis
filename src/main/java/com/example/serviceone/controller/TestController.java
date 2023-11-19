package com.example.serviceone.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true")
@RestController
public class TestController {

    @Autowired
    private HttpSession httpSession;

    @GetMapping(value = "/test")
    public Map<String, String> test(){
        System.out.println(httpSession.getId());
        Map<String, String> map = new HashMap<>();
        if (httpSession.getAttribute("randomvalue")==null){
            httpSession.setAttribute("randomvalue", "my random value for "+httpSession.getId());
        } else {
            map.put("message", String.valueOf(httpSession.getAttribute("randomvalue")));
        }
        return map;
    }

}
