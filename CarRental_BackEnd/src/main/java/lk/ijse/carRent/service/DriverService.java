package lk.ijse.carRent.service;

import lk.ijse.carRent.dto.CustomDTO;
import lk.ijse.carRent.dto.DriverDTO;
import lk.ijse.carRent.entity.Driver;

import java.util.ArrayList;

public interface DriverService {
    void saveDriver(DriverDTO dto);
    void updateDriver(DriverDTO dto);
    void deleteDriver(String reg_ID);
    ArrayList<DriverDTO> getAllDriver();
    CustomDTO userIdGenerate();
    CustomDTO getSumDriver();
    CustomDTO getSumAvailableDriver();
    CustomDTO getSumUnavailableDriver();
    ArrayList<DriverDTO> getAllAvailableDriver();
    Driver searchDriverId(String id);
}
