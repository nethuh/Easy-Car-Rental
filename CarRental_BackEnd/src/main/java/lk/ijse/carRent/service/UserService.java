package lk.ijse.carRent.service;

import lk.ijse.carRent.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {
    ArrayList<UserDTO> getAllRegUsers();
    UserDTO getRegUsers(String username,String password);
}
