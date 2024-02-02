package service;

import com.hrs.system.dev.model.Guest;
import com.hrs.system.dev.model.Stay;
import com.hrs.system.dev.model.repository.GuestRepository;
import com.hrs.system.dev.model.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService {

    private final GuestRepository guestRepository;
    private final StayRepository stayRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository, StayRepository stayRepository) {
        this.guestRepository = guestRepository;
        this.stayRepository = stayRepository;
    }

    @Transactional
    public Guest checkInGuest(Guest guest) {
        // Save or update the guest information
        Guest savedGuest = guestRepository.save(guest);

        // Create a new stay record for the guest
        Stay stay = new Stay();
        stay.setGuest(savedGuest);
        stay.setCheckInDate(LocalDate.now());
        stayRepository.save(stay);

        return savedGuest;
    }

    @Transactional
    public void checkOutGuest(Long guestId) throws Exception {
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new Exception("Guest not found with id: " + guestId));

        Stay currentStay = stayRepository.findByGuestAndCheckOutDateIsNull(guest)
                .orElseThrow(() -> new Exception("Guest is not currently checked in."));

        // Update the check-out date for the current stay
        currentStay.setCheckOutDate(LocalDate.now());
        stayRepository.save(currentStay);
    }

    public List<Guest> getAllCheckedInGuests() {
        // Fetch all stays without a check-out date
        List<Stay> stays = stayRepository.findByCheckOutDateIsNull();

        // Extract guests from the stays
        return stays.stream()
                .map(Stay::getGuest)
                .collect(Collectors.toList());
    }
}
