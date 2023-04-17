package com.example.Movie_Ticketing_Service_Application.EntryDTOs;


import lombok.Data;

import java.util.List;

@Data
public class TicketEntryDTO {

    private  int showId;

    private List<String> requestedSeats;

    private int userId;
}
