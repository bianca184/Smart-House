package com.Bianca.SmartHouse.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminUsersController {

    private final UserRepository userRepository;
    private final HouseRepository houseRepository;

    public AdminUsersController(UserRepository userRepository, HouseRepository houseRepository) {
        this.userRepository = userRepository;
        this.houseRepository = houseRepository;
    }

    @DeleteMapping("/users/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        var opt = userRepository.findByUsername(username);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();

        AppUser u = opt.get();
        House h = u.getHouse();

        userRepository.delete(u);

        // 1) dacă user-ul era legat la casă, o ștergi
        if (h != null) {
            houseRepository.deleteById(h.getId());
        } else {
            // 2) fallback: șterge casa după nume (pentru cazuri “orfane”)
            houseRepository.findByName(username).ifPresent(houseRepository::delete);
            houseRepository.findByName(username + "'s house").ifPresent(houseRepository::delete);
        }

        return ResponseEntity.ok("Sters user + casa: " + username);
    }
}
