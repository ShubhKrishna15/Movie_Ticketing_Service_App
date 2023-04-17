package com.example.Movie_Ticketing_Service_Application.Repositories;

import com.example.Movie_Ticketing_Service_Application.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show,Integer> {
}
