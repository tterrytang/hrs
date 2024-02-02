package service;

import Repositories.GuestRepository;
import Repositories.ParcelRepository;
import Repositories.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelService {

    private final ParcelRepository parcelRepository;
    private final GuestRepository guestRepository;
    private final StayRepository stayRepository;

    @Autowired
    public ParcelService(ParcelRepository parcelRepository, GuestRepository guestRepository, StayRepository stayRepository) {
        this.parcelRepository = parcelRepository;
        this.guestRepository = guestRepository;
        this.stayRepository = stayRepository;
    }

    public Parcel acceptParcelForGuest(Long guestId, Parcel parcel) throws Exception {
        Optional<Guest> guest = guestRepository.findById(guestId);
        if (!guest.isPresent()) {
            throw new Exception("Guest not found");
        }

        Optional<Stay> stay = stayRepository.findByGuestAndCheckOutDateIsNull(guest.get());
        if (!stay.isPresent()) {
            throw new Exception("Guest is not currently checked in");
        }

        parcel.setGuest(guest.get());
        return parcelRepository.save(parcel);
    }

    public List<Parcel> getParcelsForGuestAtCheckOut(Long guestId) throws Exception {
        Optional<Guest> guest = guestRepository.findById(guestId);
        if (!guest.isPresent()) {
            throw new Exception("Guest not found");
        }

        return parcelRepository.findByGuestAndPickedUp(guest.get(), false);
    }

    // Add more service methods as necessary
}