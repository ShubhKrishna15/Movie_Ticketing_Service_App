package com.example.Movie_Ticketing_Service_Application.Converters;

import com.example.Movie_Ticketing_Service_Application.EntryDTOs.TicketEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Models.Ticket;

public class TicketEntryConverter {

    public static Ticket covertDTO(TicketEntryDTO ticketEntryDTO){

        Ticket ticket = new Ticket();
        return ticket;
    }
}
