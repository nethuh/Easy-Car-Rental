package lk.ijse.carRent.repo;

import lk.ijse.carRent.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface CarRepo extends JpaRepository<Car, String> {
    @Query(value = "SELECT car_Id FROM Car ORDER BY car_Id DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT COUNT(car_Id) FROM Car", nativeQuery = true)
    int getSumCar();

    @Query(value = "SELECT * FROM Car WHERE name=?1 or fuel_Type=?2 and type=?3 and transmission_Type=?4 and vehicleAvailabilityType='AVAILABLE'", nativeQuery = true)
    ArrayList<Car> filterCarDetails(String name, String fuel_Type, String type, String transmission_Type);

    @Query(value = "SELECT * FROM Car WHERE type =?1 and fuel_Type=?2 and vehicleAvailabilityType='AVAILABLE' ", nativeQuery = true)
    ArrayList<Car> filterCar(String type, String fuel_Type);

}

