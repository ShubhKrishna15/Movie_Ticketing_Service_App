package com.example.Movie_Ticketing_Service_Application.Models;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
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





}
