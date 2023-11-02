package lk.ijse.carRent.service.impl;

import lk.ijse.carRent.dto.CustomDTO;
import lk.ijse.carRent.dto.DriverDTO;
import lk.ijse.carRent.entity.Driver;
import lk.ijse.carRent.entity.User;
import lk.ijse.carRent.repo.DriverRepo;
import lk.ijse.carRent.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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
        Driver driver = new Driver(dto.getUser_Id(), dto.getName(), dto.getContact_No(), dto.getAddress(), dto.getEmail(), dto.getNic_No(), dto.getLicense_No(), "", dto.getDriverAvailability(), new User(dto.getUser().getUser_Id(),dto.getUser().getRole_Type(),dto.getUser().getUser_Name(),dto.getUser().getPassword()));
        System.out.println(driver);
        if (repo.existsById(dto.getUser_Id())) throw new RuntimeException("Driver Already Exist. Please enter another id..!");

        try {
//            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
//            File uploadsDir = new File(projectPath + "/uploads");
//            System.out.println(projectPath);

            String imagePath = "D:/apache-tomcat-8.5.90-windows-x64/apache-tomcat-8.5.90/bin/src/imagePath";
            File uploadsDir = new File(imagePath);
            uploadsDir.mkdir();

            dto.getLicense_Img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicense_Img().getOriginalFilename()));

            driver.setLicense_Img("uploads/" + dto.getLicense_Img().getOriginalFilename());

        } catch (IOException  e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver);
        repo.save(driver);

    }

    @Override
    public void updateDriver(DriverDTO dto) {
        Driver driver = new Driver(dto.getUser_Id(), dto.getName(), dto.getContact_No(), dto.getAddress(), dto.getEmail(), dto.getNic_No(), dto.getLicense_No(), "", dto.getDriverAvailability(), new User(dto.getUser().getUser_Id(), dto.getUser().getRole_Type(), dto.getUser().getUser_Name(), dto.getUser().getPassword()));
        System.out.println(driver);
        if (!repo.existsById(dto.getUser_Id())) {
            throw new RuntimeException("Driver Not Exist. Please enter Valid id..!");
        }

        try {
//            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
//            File uploadsDir = new File(projectPath + "/uploads");
//            System.out.println(projectPath);

            String imagePath = "D:/apache-tomcat-8.5.90-windows-x64/apache-tomcat-8.5.90/bin/src/imagePath";
            File uploadsDir = new File(imagePath);
            uploadsDir.mkdir();

            dto.getLicense_Img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicense_Img().getOriginalFilename()));

            driver.setLicense_Img("uploads/" + dto.getLicense_Img().getOriginalFilename());

        } catch (IOException  e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver);
        repo.save(driver);

    }

    @Override
    public void deleteDriver(String driver_ID) {
        if (!repo.existsById(driver_ID)){
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        repo.deleteById(driver_ID);

    }

    @Override
    public ArrayList<DriverDTO> getAllDriver() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<Driver>>() {
        }.getType());
    }

    @Override
    public CustomDTO userIdGenerate() {
        return new CustomDTO(repo.getLastIndex());
    }

    @Override
    public CustomDTO getSumDriver() {
        return new CustomDTO(repo.getSumDriver());
    }

    @Override
    public CustomDTO getSumAvailableDriver() {
        return new CustomDTO(repo.getSumAvailableDriver());
    }

    @Override
    public CustomDTO getSumUnavailableDriver() {
        return new CustomDTO(repo.getSumUnavailableDriver());
    }

    @Override
    public ArrayList<DriverDTO> getAllAvailableDriver() {
        return mapper.map(repo.availableDrivers(),new TypeToken<ArrayList<Driver>>(){

        }.getType());
    }

    @Override
    public Driver searchDriverId(String id) {
        if (!repo.existsById(id)){
            throw new RuntimeException("Wrong ID. Please enter Valid id..!");
        }
        return mapper.map(repo.findById(id).get(),Driver.class);
    }
}
