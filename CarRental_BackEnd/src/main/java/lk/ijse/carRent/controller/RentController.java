package lk.ijse.carRent.controller;

import lk.ijse.carRent.dto.CustomDTO;
import lk.ijse.carRent.dto.RentDTO;
import lk.ijse.carRent.service.RentService;
import lk.ijse.carRent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/rent")
public class RentController {
    @Autowired
    private RentService service;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/rentIdGenerate")
    public @ResponseBody CustomDTO customerIdGenerate(){
        return service.rentIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil placeOrder(@RequestBody RentDTO dto){
       service.bookingCars(dto);
       return new ResponseUtil("Ok", "Successfully Purchased.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllRents")
    public ResponseUtil getAllRents(){
        System.out.println(service.getAllRent());
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllRent());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/rentReject", params = {"rentID", "driverId"})
    public ResponseUtil bookingReject(@RequestParam String rentID, @RequestParam String driverId){
        service.bookingReject(rentID, driverId);
        return new ResponseUtil("OK", "Successfully Conformed.!", null);
    }

    @ResponseStatus(HttpStatus.CONTINUE)
    @PostMapping(path = "/rentConform", params = {"rentID", "driverId"})
    public ResponseUtil bookingConform(@RequestParam String rentID, @RequestParam String driverId){
        service.bookingConform(rentID, driverId);
        return new ResponseUtil("OK", "Successfully Conformed.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/booking")
    public @ResponseBody CustomDTO getSumOfBooking(){
        return service.getSumOfBooking();
    }
}
