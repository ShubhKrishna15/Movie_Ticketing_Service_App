package com.example.Movie_Ticketing_Service_Application.Services;


import com.example.Movie_Ticketing_Service_Application.Converters.MovieConverter;
import com.example.Movie_Ticketing_Service_Application.EntryDTOs.MovieEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Models.Movie;
import com.example.Movie_Ticketing_Service_Application.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDTO movieEntryDto)throws Exception{


        Movie movieEntity = MovieConverter.convertEntryDtoToEntity(movieEntryDto);

        movieRepository.save(movieEntity);

        return "Movie Added successfully";


    }
}
