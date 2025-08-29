package com.fredrik.webservice_uppgifter_lektion_5.controller;

import com.fredrik.webservice_uppgifter_lektion_5.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    List<User> userList = new ArrayList<>(
            (Arrays.asList(
                    new User(0, "Fredrik", "Lösenord123", true),
                    new User(1,  "Håkan", "Lösenord123", true),
                    new User(2, "Benny", "HejPåDig", false)
            ))
    );

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
    @GetMapping("/notfound")
    public ResponseEntity<String> getNotFoundError(){
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<String> deleteUser (@PathVariable ("id") Long id){
        for (User user : userList){
            if (user.id() == id){
                userList.remove(user);

                return ResponseEntity.status(200).body("User with id " + id + " was deleted");
            }

        }

        return ResponseEntity.status(404).body("User with id " + id + " was not found");
    }






}
