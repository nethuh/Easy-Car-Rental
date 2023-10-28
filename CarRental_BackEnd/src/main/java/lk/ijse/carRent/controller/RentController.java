package lk.ijse.carRent.controller;

import lk.ijse.carRent.dto.CustomDTO;
import lk.ijse.carRent.service.RentService;
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
}
