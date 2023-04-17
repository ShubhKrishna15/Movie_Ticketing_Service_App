package com.example.Movie_Ticketing_Service_Application.Converters;

import com.example.Movie_Ticketing_Service_Application.EntryDTOs.MovieEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Models.Movie;

public class MovieConverter {

    public static Movie convertEntryDtoToEntity(MovieEntryDTO movieEntryDto){

        Movie movieEntity = Movie.builder()
                .movieName(movieEntryDto.getMovieName()).duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre()).language(movieEntryDto.getLanguage()).ratings(movieEntryDto.getRatings()).build();

        return movieEntity;
    }
}
