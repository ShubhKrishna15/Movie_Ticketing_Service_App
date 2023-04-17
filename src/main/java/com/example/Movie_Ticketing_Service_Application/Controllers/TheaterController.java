package com.example.Movie_Ticketing_Service_Application.Controllers;


import com.example.Movie_Ticketing_Service_Application.EntryDTOs.TheaterEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Theater")
public class TheaterController {


    @Autowired
    TheaterService theaterService;

    @PostMapping("/addTheater")
    public ResponseEntity<String> addTheater (@RequestBody TheaterEntryDTO theaterEntryDTO){

        try{
            return new ResponseEntity<>(theaterService.addTheater(theaterEntryDTO), HttpStatus.CREATED);

        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }


    }
}
