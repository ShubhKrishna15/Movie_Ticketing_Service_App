package com.example.Movie_Ticketing_Service_Application.Converters;

import com.example.Movie_Ticketing_Service_Application.EntryDTOs.UserEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Models.User;

public class UserConverter {

    //Static we are using as a specific use case here, but it cant replace the advantage of objects
    public static User convertDTO(UserEntryDTO userEntryDTO){


        User user = User.builder().name(userEntryDTO.getName()).email(userEntryDTO.getEmail()).age(userEntryDTO.getAge())
                .address(userEntryDTO.getAddress()).mobNo(userEntryDTO.getMobNo()).build();
        return user;
    }
}
