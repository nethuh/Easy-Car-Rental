package lk.ijse.carRent.service;

import lk.ijse.carRent.dto.RegUserDTO;
import lk.ijse.carRent.entity.RegUser;

import java.util.ArrayList;

public interface RegUserService {
    void saveUser(RegUserDTO dto);
    void updateUser(RegUserDTO dto);
    void deleteUser(String reg_ID);
    ArrayList<RegUserDTO> getAllUser();
    RegUser searchUserId(String id);
    RegUserDTO availableUser(String userName);

}
