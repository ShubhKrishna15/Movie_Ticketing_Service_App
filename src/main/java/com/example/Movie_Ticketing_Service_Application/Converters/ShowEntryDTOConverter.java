package com.example.Movie_Ticketing_Service_Application.Converters;

import com.example.Movie_Ticketing_Service_Application.EntryDTOs.ShowEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Models.Show;

public class ShowEntryDTOConverter {


    public static Show convertDto(ShowEntryDTO showEntryDTO){

        Show show = Show.builder()
                .showDate(showEntryDTO.getShowDate())
                .showTime(showEntryDTO.getShowTime())
                .showType(showEntryDTO.getShowType())
                .build();


       return show;

    }
}
