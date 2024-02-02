package Repositories;

import hrs.system.dev.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    // Custom query methods can be defined here if needed
}
