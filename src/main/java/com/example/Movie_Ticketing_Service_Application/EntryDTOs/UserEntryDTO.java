package com.example.Movie_Ticketing_Service_Application.EntryDTOs;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NonNull;


@Data
public class UserEntryDTO {


    private String name;


    private String email;

    private int age ;

    private String address;


    private String mobNo;
}
