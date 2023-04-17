package com.example.Movie_Ticketing_Service_Application.Repositories;


import com.example.Movie_Ticketing_Service_Application.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {
}
