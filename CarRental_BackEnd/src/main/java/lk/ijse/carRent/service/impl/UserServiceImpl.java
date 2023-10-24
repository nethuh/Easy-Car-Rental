package lk.ijse.carRent.service.impl;

import lk.ijse.carRent.dto.UserDTO;
import lk.ijse.carRent.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    public ArrayList<UserDTO> getAllRegUsers() {
        return null;
    }

    public UserDTO getRegUsers(String username, String password) {
        return null;
    }
}
