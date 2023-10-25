package lk.ijse.carRent.repo;

import lk.ijse.carRent.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, String> {
}
