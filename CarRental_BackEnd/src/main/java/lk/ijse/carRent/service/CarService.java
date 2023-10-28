package lk.ijse.carRent.service;

import lk.ijse.carRent.dto.CarDTO;
import lk.ijse.carRent.dto.CustomDTO;
import lk.ijse.carRent.entity.Car;

import java.util.ArrayList;

public interface CarService {
    void saveCar(CarDTO dto);
    void updateCar(CarDTO dto);
    void deleteCar(String car_Id);
    ArrayList<CarDTO> getAllCar();
    CustomDTO carIdGenerate();
    Car searchCarId(String id);
    CustomDTO getSumCar();
    ArrayList<CarDTO> getFilerData(String type,String fuelType);
    ArrayList<CarDTO> filterCarDetails(String name, String fuel_Type,String type, String transmission_Type);
}
