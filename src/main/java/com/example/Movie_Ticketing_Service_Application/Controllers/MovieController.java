package com.example.Movie_Ticketing_Service_Application.Controllers;


import com.example.Movie_Ticketing_Service_Application.Models.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Movie")
public class MovieController {


    @PostMapping("/add")
    public ResposeEntity<String> addMovie (@RequestBody Movie movie){
                return new ResponseEntity<>(null, HttpStatus.PROCESSING);
    }
}
