package com.example.trabajofinalv1.controller.Login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {

    @GetMapping("/login/") //  /login/
    public ResponseEntity<?> logearse(){
        return ResponseEntity.ok("<h1>Usted se ha logueado</h1>");
    }


}
