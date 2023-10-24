package lk.ijse.carRent.service.impl;

import lk.ijse.carRent.dto.Reg_UserDTO;
import lk.ijse.carRent.entity.Reg_User;
import lk.ijse.carRent.entity.User;
import lk.ijse.carRent.repo.Reg_UserRepo;
import lk.ijse.carRent.service.Reg_UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;

@Service
@Transactional
public class Reg_UserServiceImpl implements Reg_UserService {
    @Autowired
    private Reg_UserRepo repo;

    @Autowired
    private ModelMapper mapper;

    public void saveUser(Reg_UserDTO dto) {

        Reg_User regUser = new Reg_User(dto.getUser_Id(), dto.getName(), dto.getContact_No(), dto.getAddress(), dto.getEmail(), dto.getNic(), dto.getLicense_No(), "","",new User(dto.getUser().getUser_Id(), dto.getUser().getRole_Type(),dto.getUser().getUser_Name(), dto.getUser().getPassword()));
        if (repo.existsById(dto.getUser_Id()))
            throw new RuntimeException("User Already Exist. Please enter another id..!");

        try{
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            dto.getNic_Img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getNic_Img().getOriginalFilename()));
            dto.getLicense_Img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getLicense_Img().getOriginalFilename()));

            regUser.setNic_Img("uploads/" + dto.getNic_Img().getOriginalFilename());
            regUser.setLicense_Img("uploads/" + dto.getLicense_Img().getOriginalFilename());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(regUser);
        repo.save(regUser);

    }

    public void updateUser(Reg_UserDTO dto) {

    }

    public void deleteUser(String reg_ID) {

    }

    public ArrayList<Reg_UserDTO> getAllUser() {
        return null;
    }

    public Reg_User searchUserId(String id) {
        return null;
    }

    public Reg_UserDTO availableUser(String userName) {
        return null;
    }
}