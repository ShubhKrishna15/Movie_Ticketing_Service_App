package com.example.Movie_Ticketing_Service_Application.Models;


import com.example.Movie_Ticketing_Service_Application.Enums.Genre;
import com.example.Movie_Ticketing_Service_Application.Enums.Language;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "movie")
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(unique = true,nullable = false)
    private String movieName;

    private double rating;

    private int duration;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;




}
