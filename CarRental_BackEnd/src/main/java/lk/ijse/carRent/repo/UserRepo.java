package lk.ijse.carRent.repo;

import lk.ijse.carRent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
