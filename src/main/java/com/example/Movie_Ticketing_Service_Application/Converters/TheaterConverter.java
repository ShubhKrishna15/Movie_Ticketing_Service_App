package com.example.Movie_Ticketing_Service_Application.Converters;


import com.example.Movie_Ticketing_Service_Application.EntryDTOs.TheaterEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Models.Theater;
import lombok.Data;

public class TheaterConverter {

    public static Theater convertDto(TheaterEntryDTO theaterEntryDTO){

        Theater theater = Theater.builder().name(theaterEntryDTO.getName()).location(theaterEntryDTO.getLocation()).build();
        return theater;
    }



}
