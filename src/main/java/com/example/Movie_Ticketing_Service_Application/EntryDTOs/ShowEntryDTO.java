package com.example.Movie_Ticketing_Service_Application.EntryDTOs;


import com.example.Movie_Ticketing_Service_Application.Enums.showType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDTO {

    private LocalDate showDate;

    private LocalTime showTime;

    private showType showType;

    private int movieId;

    private int theaterId;

    private int classicSeatPrice;

    private int premiumSeatPrice;


}
