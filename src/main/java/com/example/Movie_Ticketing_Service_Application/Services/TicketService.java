package com.example.Movie_Ticketing_Service_Application.Services;


import com.example.Movie_Ticketing_Service_Application.Converters.TicketEntryConverter;
import com.example.Movie_Ticketing_Service_Application.EntryDTOs.TicketEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Models.Show;
import com.example.Movie_Ticketing_Service_Application.Models.ShowSeat;
import com.example.Movie_Ticketing_Service_Application.Models.Ticket;
import com.example.Movie_Ticketing_Service_Application.Models.User;
import com.example.Movie_Ticketing_Service_Application.Repositories.ShowRepository;
import com.example.Movie_Ticketing_Service_Application.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    int totalAmount  = 0;
    public String addTicket(TicketEntryDTO ticketEntryDTO) throws Exception{

        Ticket ticket = TicketEntryConverter.covertDTO(ticketEntryDTO);

        int showId = ticketEntryDTO.getShowId();
        Show show = showRepository.findById(showId).get();

        List<String> requestedSeats = ticketEntryDTO.getRequestedSeats();


        //checking for validity weather the mentioned seat are available or not

        Boolean checkValidity = areSeatsValid(ticketEntryDTO);
        if(checkValidity==false){
            throw new Exception("Requested seats are already booked");
        }

        ticket.setTotalAmount(totalAmount);

        String allotedSeats = getAllotedSeatsFromRequestedSeatList(requestedSeats);
        ticket.setBookedSeats(allotedSeats);

        //Setting the other key Attribute
        ticket.setMovieName(show.getMovie().getMovieName());
        ticket.setShowDate(show.getShowDate());
        ticket.setShowTime(show.getShowTime());
        ticket.setTheaterName(show.getTheater().getName());

        // Setting the Mapped attributes
        User user = userRepository.findById(ticketEntryDTO.getUserId()).get();
        ticket.setUser(user);
        ticket.setShow(show);

        //Setting the parents
        List<Ticket>ticketList = user.getBookedTickets();
        ticketList.add(ticket);
        user.setBookedTickets(ticketList);

        List<Ticket> ticketList1 = show.getListOfBookedTickets();
        ticketList1.add(ticket);
        show.setListOfBookedTickets(ticketList1);

        showRepository.save(show);
        userRepository.save(user);


        return "Your tickets are successfully Booked" ;

    }
    private String getAllotedSeatsFromRequestedSeatList(List<String>requestedSeats){
        String result = "" ;
        for(String seat : requestedSeats){

            result = result + seat+", ";


        }
        return result;
    }

    private Boolean areSeatsValid(TicketEntryDTO ticketEntryDTO ){


        List<String> ListOfRequestedSeats = ticketEntryDTO.getRequestedSeats();

        int showId = ticketEntryDTO.getShowId();
        Show show = showRepository.findById(showId).get();


        List<ShowSeat> showSeatList = show.getShowSeatList();

       for(ShowSeat showSeat : showSeatList ){
           String seatNumber = showSeat.getSeatNo();
           if(ListOfRequestedSeats.contains(seatNumber)){
               if(showSeat.isBooked()){
                   return false;
               }
               totalAmount += showSeat.getPrice();
               showSeat.setBooked(true);
               showSeat.setBookedAt(new Date());
           }

       }

       return true;



    }
}
