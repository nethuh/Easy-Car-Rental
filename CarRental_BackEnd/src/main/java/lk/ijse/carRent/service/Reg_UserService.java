package lk.ijse.carRent.service;

import lk.ijse.carRent.dto.CustomDTO;
import lk.ijse.carRent.dto.Reg_UserDTO;
import lk.ijse.carRent.entity.Reg_User;

import java.util.ArrayList;

public interface Reg_UserService {
    void saveUser(Reg_UserDTO dto);
    void updateUser(Reg_UserDTO dto);
    void deleteUser(String reg_ID);
    ArrayList<Reg_UserDTO> getAllUser();
    Reg_User searchUserId(String id);
    Reg_UserDTO availableUser(String userName);
    CustomDTO userIdGenerate();
    CustomDTO getSumUser();
}
