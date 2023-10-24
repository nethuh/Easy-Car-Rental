package lk.ijse.carRent.repo;

import lk.ijse.carRent.entity.RegUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegUserRepo extends JpaRepository<RegUser, String> {
}
