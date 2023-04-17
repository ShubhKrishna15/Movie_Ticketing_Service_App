package com.example.Movie_Ticketing_Service_Application.Services;


import com.example.Movie_Ticketing_Service_Application.Converters.ShowEntryDTOConverter;
import com.example.Movie_Ticketing_Service_Application.EntryDTOs.ShowEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Enums.SeatType;
import com.example.Movie_Ticketing_Service_Application.Models.*;
import com.example.Movie_Ticketing_Service_Application.Repositories.MovieRepository;
import com.example.Movie_Ticketing_Service_Application.Repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookMyShowService {



    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    MovieRepository movieRepository;

    public String addShow(ShowEntryDTO showEntryDTO) throws Exception{

        Show showEntity = ShowEntryDTOConverter.convertDto(showEntryDTO);

        Movie movie = movieRepository.findById(showEntryDTO.getMovieId()).get();
        Theater theater = theaterRepository.findById(showEntryDTO.getTheaterId()).get();


        showEntity.setMovie(movie);
        showEntity.setTheater(theater);

        List<ShowSeat> showSeatList = createSeatList(showEntryDTO,showEntity);

        showEntity.setShowSeatList(showSeatList);

        List<Show> shows = movie.getShowMovieList();
        shows.add(showEntity);
        movie.setShowMovieList(shows);

        List<Show> shows1 = theater.getListOfTheaterShows();
        shows1.add(showEntity);
        theater.setListOfTheaterShows(shows1);

        theaterRepository.save(theater);
        movieRepository.save(movie);



        return "You have Successfully created your Show";


    }
    private List<ShowSeat>createSeatList(ShowEntryDTO showEntryDTO,Show showEntity){


        List<TheaterSeat> theaterSeatList = showEntity.getTheater().getTheaterSeatList();
        List<ShowSeat>ans = new ArrayList<>();

        for(TheaterSeat theaterSeat : theaterSeatList  ){

            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setBooked(false);
            showSeat.setSeatType(theaterSeat.getSeatType());
            if(theaterSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setPrice(showEntryDTO.getClassicSeatPrice());
            }else{
                showSeat.setPrice(showEntryDTO.getPremiumSeatPrice());
            }
            showSeat.setShow(showEntity);
            ans.add(showSeat);
        }

        return ans;
    }


}
