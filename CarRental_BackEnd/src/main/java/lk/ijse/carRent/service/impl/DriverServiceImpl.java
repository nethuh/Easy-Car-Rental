package lk.ijse.carRent.service.impl;

import lk.ijse.carRent.dto.DriverDTO;
import lk.ijse.carRent.repo.DriverRepo;
import lk.ijse.carRent.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {

    }

    @Override
    public void updateDriver(DriverDTO dto) {

    }

    @Override
    public void deleteDriver(String reg_ID) {

    }

    @Override
    public ArrayList<DriverDTO> getAllDriver() {
        return null;
    }
}
