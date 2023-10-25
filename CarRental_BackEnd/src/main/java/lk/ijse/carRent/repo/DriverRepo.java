package lk.ijse.carRent.repo;

import lk.ijse.carRent.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepo extends JpaRepository<Driver, String> {
    @Query(value = "SELECT user_Id FROM Driver ORDER BY user_Id DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}
