package Repositories;

import hrs.system.dev.model.Guest;
import hrs.system.dev.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StayRepository extends JpaRepository<Stay, Long> {
    Optional<Stay> findByGuestAndCheckOutDateIsNull(Guest guest);
}
