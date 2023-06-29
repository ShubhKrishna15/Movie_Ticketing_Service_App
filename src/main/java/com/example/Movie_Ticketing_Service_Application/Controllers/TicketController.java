package com.example.Movie_Ticketing_Service_Application.Controllers;


import com.example.Movie_Ticketing_Service_Application.EntryDTOs.TicketEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public String bookTicket(@RequestBody TicketEntryDTO ticketEntryDTO){
            try{
                    String  result  = ticketService.addTicket(ticketEntryDTO);
                    return result;

            }catch(Exception e){

                return "Error";


            }

    }
}
