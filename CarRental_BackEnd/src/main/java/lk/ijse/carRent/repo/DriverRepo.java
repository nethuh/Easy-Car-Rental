package lk.ijse.carRent.repo;

import lk.ijse.carRent.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver, String> {
}
