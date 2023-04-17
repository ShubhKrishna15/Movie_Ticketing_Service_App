package com.example.Movie_Ticketing_Service_Application.Services;


import com.example.Movie_Ticketing_Service_Application.Converters.TicketEntryConverter;
import com.example.Movie_Ticketing_Service_Application.EntryDTOs.TicketEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Models.Show;
import com.example.Movie_Ticketing_Service_Application.Models.ShowSeat;
import com.example.Movie_Ticketing_Service_Application.Models.Ticket;
import com.example.Movie_Ticketing_Service_Application.Repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    ShowRepository showRepository;
    public String bookTicket(TicketEntryDTO ticketEntryDTO){

        Ticket ticket = TicketEntryConverter.covertDTO(ticketEntryDTO);


        //checking for validity weather the mentioned seat are available or not

        Boolean checkValidity = areSeatsValid(ticketEntryDTO);
    }

    private Boolean areSeatsValid(TicketEntryDTO ticketEntryDTO ){


        List<String> ListOfRequestedSeats = ticketEntryDTO.getRequestedSeats();

        int showId = ticketEntryDTO.getShowId();
        Show show = showRepository.findById(showId).get();

        List<ShowSeat> showSeatList = show.getShowSeatList();



    }
}
