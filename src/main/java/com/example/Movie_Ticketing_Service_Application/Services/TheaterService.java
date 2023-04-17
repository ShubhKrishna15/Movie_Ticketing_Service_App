package com.example.Movie_Ticketing_Service_Application.Services;


import com.example.Movie_Ticketing_Service_Application.Converters.TheaterConverter;
import com.example.Movie_Ticketing_Service_Application.EntryDTOs.TheaterEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Enums.SeatType;
import com.example.Movie_Ticketing_Service_Application.Models.Theater;
import com.example.Movie_Ticketing_Service_Application.Models.TheaterSeat;
import com.example.Movie_Ticketing_Service_Application.Repositories.TheaterRepository;
import com.example.Movie_Ticketing_Service_Application.Repositories.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    public String addTheater (TheaterEntryDTO theaterEntryDTO) throws Exception{


        Theater theater = TheaterConverter.convertDto(theaterEntryDTO);
        List<TheaterSeat>theaterSeats = theaterSeatList(theaterEntryDTO,theater);
        theater.setTheaterSeatList(theaterSeats);



        theaterRepository.save(theater);

        return "Theater Add successfully with the given classic and premium seats";



    }

    public List<TheaterSeat> theaterSeatList (TheaterEntryDTO theaterEntryDTO,Theater myTheater){

        int classicSeats  = theaterEntryDTO.getClassicSeatsCount();
        int premiumSeats = theaterEntryDTO.getPremiumSeatsCount();

         List<TheaterSeat> ans  = new ArrayList<>();

        for(int i = 0 ; i < classicSeats ; i++){

            TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(i+"C").seatType(SeatType.CLASSIC).theater(myTheater).build();
            ans.add(theaterSeat);

        }
        for(int i=0 ; i < premiumSeats ; i++){
            TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(i+"P").seatType(SeatType.PREMIUM).theater(myTheater).build();
            ans.add(theaterSeat);

        }


        return ans;
    }
}
