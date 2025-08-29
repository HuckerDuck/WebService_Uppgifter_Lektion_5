package com.fredrik.webservice_uppgifter_lektion_5.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping("/ok")
    // Raw Use - Du har inte valt vilken data typ du behöver
    // Skriv <String>
    public ResponseEntity<String> getOK(){
        // ResponseEntity liknar en ArrayList eller List
        // Har en samma struktur med <E> (List)
        // ResponseEntity är en class, skriv alltid .

        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/badrequest")

    public ResponseEntity<String> getBadRequest(){


        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/internalservererror")

    public ResponseEntity<String> getInternalServerError(){
        return ResponseEntity.internalServerError().build();
    }


}
