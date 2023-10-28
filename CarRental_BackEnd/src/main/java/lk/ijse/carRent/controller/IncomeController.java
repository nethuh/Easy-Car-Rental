package lk.ijse.carRent.controller;

import lk.ijse.carRent.dto.IncomeDTO;
import lk.ijse.carRent.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/income")
public class IncomeController {

    @Autowired
    private IncomeService service;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/dailyIncome")
    public @ResponseBody ArrayList<IncomeDTO> dailyIncome(){
        return service.dailyIncome();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/monthlyIncome")
    public @ResponseBody ArrayList<IncomeDTO>monthlyIncome(){
        return service.monthlyIncome();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/AnnuallyIncome")
    public @ResponseBody ArrayList<IncomeDTO> annuallyIncome(){
        return service.AnnuallyIncome();
    }
}
