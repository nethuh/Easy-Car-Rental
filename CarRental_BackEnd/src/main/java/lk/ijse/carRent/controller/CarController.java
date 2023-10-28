package lk.ijse.carRent.controller;

import lk.ijse.carRent.dto.CarDTO;
import lk.ijse.carRent.dto.CustomDTO;
import lk.ijse.carRent.dto.ImageDTO;
import lk.ijse.carRent.dto.Rate;
import lk.ijse.carRent.entity.Car;
import lk.ijse.carRent.service.CarService;
import lk.ijse.carRent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDTO dto, @ModelAttribute Rate rate, @ModelAttribute ImageDTO image){
        dto.setImage(image);
        dto.setRent_Duration_Price(rate);
        System.out.println(dto);
        service.saveCar(dto);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/carIDGenerate")
    public @ResponseBody CustomDTO customerIdGenerate() {
        return service.carIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllCars")
    public ResponseUtil getAllCar() {
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllCar());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchCar", params = {"car_Id"})
    public Car searchCusId(String car_Id){
        return service.searchCarId(car_Id);
    }
}
