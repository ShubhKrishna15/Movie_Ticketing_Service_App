package com.example.Movie_Ticketing_Service_Application.EntryDTOs;


import lombok.Data;

@Data
public class TheaterEntryDTO {


    private String name;
    private String location;

    private int classicSeatsCount;
    private int premiumSeatsCount;

}
