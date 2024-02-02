package com.hrs.api.controller.user;

import com.hrs.system.dev.model.Guest;
import com.hrs.system.dev.service.user.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests") // Ensure this mapping is consistent with your API design
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping("/check-in")
    public ResponseEntity<?> checkInGuest(@RequestBody Guest guest) {
        try {
            Guest checkedInGuest = guestService.checkInGuest(guest);
            return ResponseEntity.ok(checkedInGuest);
        } catch (Exception e) {
            // Log the exception (not shown here) and return a meaningful error response
            return ResponseEntity.badRequest().body("Check-in failed: " + e.getMessage());
        }
    }

    @PostMapping("/check-out/{guestId}")
    public ResponseEntity<?> checkOutGuest(@PathVariable Long guestId) {
        try {
            guestService.checkOutGuest(guestId);
            return ResponseEntity.ok().body("Guest checked out successfully");
        } catch (Exception e) {
            // Log the exception (not shown here) and return a meaningful error response
            return ResponseEntity.badRequest().body("Check-out failed: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Guest>> listAllGuests() {
        List<Guest> guests = guestService.getAllGuests();
        return ResponseEntity.ok(guests);
    }
}
