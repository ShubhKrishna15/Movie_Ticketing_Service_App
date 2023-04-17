package com.example.Movie_Ticketing_Service_Application.Controllers;


import com.example.Movie_Ticketing_Service_Application.EntryDTOs.UserEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserEntryDTO userEntryDTO){

        try {
            String response = userService.addUser(userEntryDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){

            String result = "User was not Added";
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);

        }

    }




}
