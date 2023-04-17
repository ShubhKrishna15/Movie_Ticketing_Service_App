package com.example.Movie_Ticketing_Service_Application.Controllers;


import com.example.Movie_Ticketing_Service_Application.EntryDTOs.ShowEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Services.BookMyShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class BookMyShowController {


    @Autowired
    BookMyShowService bookMyShowService;
    @PostMapping(value = "/create")
    public ResponseEntity<String> createShow (@RequestBody ShowEntryDTO showEntryDTO){

        try{

            return new ResponseEntity<>(bookMyShowService.addShow(showEntryDTO), HttpStatus.CREATED);
        }catch(Exception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }







    }

}
