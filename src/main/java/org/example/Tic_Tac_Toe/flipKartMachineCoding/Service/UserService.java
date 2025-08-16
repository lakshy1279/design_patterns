package org.example.Tic_Tac_Toe.flipKartMachineCoding.Service;

import org.example.Tic_Tac_Toe.flipKartMachineCoding.Models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> users;
    public UserService() {
        users = new ArrayList<>();
    }
    public void addUser(User user) {
        users.add(user);
    }
}
