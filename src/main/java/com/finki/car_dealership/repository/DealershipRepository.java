package com.finki.car_dealership.repository;

import com.finki.car_dealership.model.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealershipRepository extends JpaRepository<Dealership,Long> {
}
