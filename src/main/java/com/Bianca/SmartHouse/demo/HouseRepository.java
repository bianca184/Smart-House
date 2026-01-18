package com.Bianca.SmartHouse.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HouseRepository extends JpaRepository<House, Long> {
    boolean existsByName(String name);
    Optional<House> findByName(String name);
}
