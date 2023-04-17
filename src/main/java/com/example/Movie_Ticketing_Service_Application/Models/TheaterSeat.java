package com.example.Movie_Ticketing_Service_Application.Models;


import com.example.Movie_Ticketing_Service_Application.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "theaterSeat")
@Builder
@AllArgsConstructor
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;


    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private String seatNo;

    @ManyToOne
    @JoinColumn
    Theater theater;
}
