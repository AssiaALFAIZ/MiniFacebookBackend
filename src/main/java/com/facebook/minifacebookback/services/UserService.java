package com.facebook.minifacebookback.services;

import com.facebook.minifacebookback.dto.UserData;
import com.facebook.minifacebookback.models.DatabaseHandler;
import com.facebook.minifacebookback.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private DatabaseHandler databaseHandler;
    public UserService(DatabaseHandler handler){
        this.databaseHandler=handler;
    }

    public void saveUtilisateur(UserData userData){
        databaseHandler.insertUser(userData);

    }


}
