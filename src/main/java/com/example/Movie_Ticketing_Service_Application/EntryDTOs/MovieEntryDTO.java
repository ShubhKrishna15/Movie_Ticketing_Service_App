package com.example.Movie_Ticketing_Service_Application.EntryDTOs;


import com.example.Movie_Ticketing_Service_Application.Enums.Genre;
import com.example.Movie_Ticketing_Service_Application.Enums.Language;
import lombok.Data;

@Data
public class MovieEntryDTO {

        private String movieName;

        private double ratings;

        private int duration;

        private Language language;

        private Genre genre;


}
