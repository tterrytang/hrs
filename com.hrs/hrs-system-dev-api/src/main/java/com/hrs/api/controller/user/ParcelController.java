package com.hrs.api.controller.user;

import com.hrs.system.dev.model.Parcel;
import com.hrs.system.dev.service.user.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcels") // Adjust the request mapping if needed
public class ParcelController {

    private final ParcelService parcelService;

    @Autowired
    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @PostMapping("/accept/{guestId}")
    public ResponseEntity<?> acceptParcel(@PathVariable Long guestId, @RequestBody Parcel parcel) {
        try {
            Parcel acceptedParcel = parcelService.acceptParcelForGuest(guestId, parcel);
            return ResponseEntity.ok(acceptedParcel);
        } catch (Exception e) {
            // Logging the exception is a good practice (not shown here)
            return ResponseEntity.badRequest().body("Could not accept parcel: " + e.getMessage());
        }
    }

    @GetMapping("/pickup/{guestId}")
    public ResponseEntity<?> listParcelsForPickup(@PathVariable Long guestId) {
        try {
            List<Parcel> parcels = parcelService.getParcelsForGuestAtCheckOut(guestId);
            return ResponseEntity.ok(parcels);
        } catch (Exception e) {
            // Logging the exception is a good practice (not shown here)
            return ResponseEntity.badRequest().body("Could not retrieve parcels: " + e.getMessage());
        }
    }

}

