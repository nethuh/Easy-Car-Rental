package lk.ijse.carRent.controller;

import lk.ijse.carRent.dto.CustomDTO;
import lk.ijse.carRent.dto.Name;
import lk.ijse.carRent.dto.Reg_UserDTO;
import lk.ijse.carRent.dto.UserDTO;
import lk.ijse.carRent.entity.Reg_User;
import lk.ijse.carRent.service.Reg_UserService;
import lk.ijse.carRent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/reg_User")
public class Reg_UserController {

    @Autowired
    private Reg_UserService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveUser(@ModelAttribute Reg_UserDTO regUserDTO, @ModelAttribute UserDTO user, @ModelAttribute Name name){
        regUserDTO.setName(name);
        regUserDTO.setUser(user);
        System.out.println(regUserDTO);
        service.saveUser(regUserDTO);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/reg_UserIdGenerate")
    public @ResponseBody CustomDTO customerIdGenerate() {
        return service.userIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllUsers")
    public ResponseUtil getAllUSer(){
        return new ResponseUtil("OK", "Successfully Loaded. :",service.getAllUser());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/update")
    public ResponseUtil updateUser(@ModelAttribute Reg_UserDTO regUserDTO, @ModelAttribute UserDTO user, @ModelAttribute Name name){
        regUserDTO.setName(name);
        regUserDTO.setUser(user);
        System.out.println(user);
        System.out.println(name);
        System.out.println(regUserDTO);
        System.out.println(regUserDTO);
        return new ResponseUtil("OK", "Successfully Updated. :" + regUserDTO.getUser_Id(),null);
    }

    @ResponseStatus
    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteUser(@RequestParam String id){
        service.deleteUser(id);
        return new ResponseUtil("OK", "Successfully Deleted. :" + id, null);
    }

    @ResponseStatus
    @GetMapping(path = "/searchCustomer", params = {"cus_Id"})
    public Reg_User searchDriverId(String cus_Id){
        return service.searchUserId(cus_Id);
    }
}

