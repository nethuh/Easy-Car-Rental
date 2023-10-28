package lk.ijse.carRent.service.impl;

import lk.ijse.carRent.dto.CustomDTO;
import lk.ijse.carRent.dto.RentDTO;
import lk.ijse.carRent.repo.CarRepo;
import lk.ijse.carRent.repo.DriverRepo;
import lk.ijse.carRent.repo.RentRepo;
import lk.ijse.carRent.service.RentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private RentRepo rentRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CustomDTO rentIdGenerate() {
        return new CustomDTO(rentRepo.getLastIndex());
    }

    @Override
    public void bookingCars(RentDTO dto) {

    }

    @Override
    public ArrayList<RentDTO> getAllRent() {
        return null;
    }

    @Override
    public void deleteRent(String rentID) {

    }

    @Override
    public void bookingConform(String rentID, String driverId) {

    }

    @Override
    public void bookingReject(String rentID, String driverId) {

    }

    @Override
    public RentDTO searchId(String id) {
        return null;
    }
}
