package com.example.Movie_Ticketing_Service_Application.Repositories;

import com.example.Movie_Ticketing_Service_Application.Models.TheaterSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatRepository extends JpaRepository<TheaterSeat,Integer> {
}
