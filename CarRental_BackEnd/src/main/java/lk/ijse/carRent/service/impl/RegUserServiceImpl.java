package lk.ijse.carRent.service.impl;

import lk.ijse.carRent.dto.RegUserDTO;
import lk.ijse.carRent.entity.RegUser;
import lk.ijse.carRent.service.RegUserService;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class RegUserServiceImpl implements RegUserService {
    public void saveUser(RegUserDTO dto) {

    }

    public void updateUser(RegUserDTO dto) {

    }

    public void deleteUser(String reg_ID) {

    }

    public ArrayList<RegUserDTO> getAllUser() {
        return null;
    }

    public RegUser searchUserId(String id) {
        return null;
    }

    public RegUserDTO availableUser(String userName) {
        return null;
    }
}
