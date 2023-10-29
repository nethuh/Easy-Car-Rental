package lk.ijse.carRent.service;

import lk.ijse.carRent.dto.CustomDTO;
import lk.ijse.carRent.dto.RentDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

public interface RentService {
    CustomDTO rentIdGenerate();

    void bookingCars(@RequestBody RentDTO dto);

    ArrayList<RentDTO> getAllRent();

    void deleteRent(String rentID);

    void bookingConform(String rentID, String driverId);

    void bookingReject(String rentID, String driverId);
    RentDTO searchId(String id);
    CustomDTO getSumOfBooking();

    CustomDTO getSumOfBookingPending();

    CustomDTO getSumOfBookingActive();
}
