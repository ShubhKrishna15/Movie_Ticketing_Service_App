package com.example.Movie_Ticketing_Service_Application.Models;


import com.example.Movie_Ticketing_Service_Application.Enums.Genre;
import com.example.Movie_Ticketing_Service_Application.Enums.Language;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "movie")
@Builder
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(unique = true,nullable = false)
    private String movieName;

    private double ratings;

    private int duration;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;


    //this is the parent for the show
    @OneToMany(mappedBy = "movie" ,cascade = CascadeType.ALL)
    private List<Show> showMovieList  = new ArrayList<>();




}
