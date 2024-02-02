package Repositories;

import hrs.system.dev.model.Guest;
import hrs.system.dev.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
    List<Parcel> findByGuestAndPickedUp(Guest guest, boolean pickedUp);
}
