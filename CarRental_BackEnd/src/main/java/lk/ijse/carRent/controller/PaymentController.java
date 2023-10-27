package lk.ijse.carRent.controller;

import lk.ijse.carRent.dto.CustomDTO;
import lk.ijse.carRent.dto.PaymentDTO;
import lk.ijse.carRent.service.PaymentService;
import lk.ijse.carRent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil savePayment(@RequestBody PaymentDTO dto, @RequestParam String rentID){
        System.out.println(dto);
        System.out.println(rentID);
        service.savePayment(dto, rentID);
        return new ResponseUtil("OK", "Successfully Payment.!", null);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/paymentIdGenerate")
    public @ResponseBody CustomDTO customerIdGenerate(){
        return service.paymentIdGenerate();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public ResponseUtil getAllPayment(){
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllPayment());
    }

}
