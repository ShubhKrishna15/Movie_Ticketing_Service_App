package com.example.Movie_Ticketing_Service_Application.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
@Builder
public class User {

         /// name ,email ,age monno address

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    @NonNull
    @Column(unique = true)
    private String email;

    private int age ;

    private String address;

    @NonNull
    @Column(unique = true)
    private String mobNo;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Ticket> bookedTickets = new ArrayList<>();





}
