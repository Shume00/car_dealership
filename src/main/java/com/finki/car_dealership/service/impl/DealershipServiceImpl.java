package com.finki.car_dealership.service.impl;

import com.finki.car_dealership.model.Dealership;
import com.finki.car_dealership.model.exceptions.DealershipNotFoundException;
import com.finki.car_dealership.repository.DealershipRepository;
import com.finki.car_dealership.service.DealershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DealershipServiceImpl implements DealershipService {

    private final DealershipRepository dealershipRepository;

    public DealershipServiceImpl(DealershipRepository dealershipRepository) {
        this.dealershipRepository = dealershipRepository;
    }

    @Override
    public Dealership findById(Long id) {
        return this.dealershipRepository.findById(id).orElseThrow(()-> new DealershipNotFoundException(id));
    }

    @Override
    public List<Dealership> findAll() {
        return this.dealershipRepository.findAll();
    }

    @Override
    public Optional<Dealership> save(String name, String location) {
        return Optional.of(this.dealershipRepository.save(new Dealership(name,location)));
    }

    @Override
    public void deleteById(Long id) {
        Dealership dealership = this.findById(id);
        this.dealershipRepository.delete(dealership);
    }
}
