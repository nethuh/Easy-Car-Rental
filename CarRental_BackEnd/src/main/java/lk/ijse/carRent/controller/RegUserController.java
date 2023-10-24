package lk.ijse.carRent.controller;

import lk.ijse.carRent.service.RegUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/reg_User")
public class RegUserController {

    @Autowired
    private RegUserService service;


}
