package lk.ijse.carRent.controller;

import lk.ijse.carRent.dto.CustomDTO;
import lk.ijse.carRent.dto.DriverDTO;
import lk.ijse.carRent.embeded.Name;
import lk.ijse.carRent.dto.UserDTO;
import lk.ijse.carRent.entity.Driver;
import lk.ijse.carRent.service.DriverService;
import lk.ijse.carRent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO userDTO, @ModelAttribute Name name){
        driverDTO.setUser(userDTO);
        driverDTO.setName(name);
        service.saveDriver(driverDTO);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverIdGenerate")
    public @ResponseBody CustomDTO customerIdGenerate() {
        return service.userIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllDrivers")
    public ResponseUtil getAllDriver() {
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllDriver());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverCount")
    public @ResponseBody CustomDTO getSumDriver(){
        return service.getSumDriver();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverAvailableCount")
    public @ResponseBody CustomDTO getSumAvailableDriver(){
        return service.getSumAvailableDriver();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverUnavailableCount")
    public @ResponseBody CustomDTO getSumUnavailableDriver(){
        return service.getSumUnavailableDriver();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchDriver", params = {"driver_Id"})
    public Driver searchDriverId(String driver_Id) {
        return service.searchDriverId(driver_Id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAvailabilityDrivers")
    public ResponseUtil getAllAvailableDriver(){
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllAvailableDriver());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/update")
    public ResponseUtil updateDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO userDTO, @ModelAttribute Name name){
        driverDTO.setUser(userDTO);
        driverDTO.setName(name);
        service.updateDriver(driverDTO);
        return new ResponseUtil("OK", "Successfully Updated. :"+ driverDTO.getUser_Id(),null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(path = {"id"})
    public ResponseUtil deleteDriver(@RequestParam String id){
        service.deleteDriver(id);
        return new ResponseUtil("OK", "Successfully Deleted. :" + id, null);
    }

}
