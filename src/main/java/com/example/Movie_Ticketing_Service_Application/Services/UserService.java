package com.example.Movie_Ticketing_Service_Application.Services;


import com.example.Movie_Ticketing_Service_Application.Converters.UserConverter;
import com.example.Movie_Ticketing_Service_Application.EntryDTOs.UserEntryDTO;
import com.example.Movie_Ticketing_Service_Application.Models.User;
import com.example.Movie_Ticketing_Service_Application.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDTO userEntryDTO) throws Exception{


        User user = UserConverter.convertDTO(userEntryDTO);

        userRepository.save(user);

        return "User added Successfully";

    }

}
