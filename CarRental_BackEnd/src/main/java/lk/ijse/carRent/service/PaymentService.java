package lk.ijse.carRent.service;

import lk.ijse.carRent.dto.CustomDTO;
import lk.ijse.carRent.dto.PaymentDTO;

import java.util.ArrayList;

public interface PaymentService {
    CustomDTO paymentIdGenerate();
    void savePayment(PaymentDTO dto,String rentID);
    ArrayList<PaymentDTO> getAllPayment();
}
