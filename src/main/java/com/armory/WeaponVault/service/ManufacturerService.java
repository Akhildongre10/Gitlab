package com.armory.WeaponVault.service;

import com.armory.WeaponVault.entity.Manufacturer;
import com.armory.WeaponVault.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    // Get all manufacturers
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    // Get a manufacturer by ID
    public Optional<Manufacturer> getManufacturerById(Long id) {
        return manufacturerRepository.findById(id);
    }

    //Get a manufacturer by Name
    public Optional<Manufacturer> getManufacturerByName(String name) {
        return manufacturerRepository.findByName(name);
    }


    // Create  a manufacturer
    @Transactional
    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    //update a manufacturer
    @Transactional
    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    //Find Manufacturer By ID
    public List<Manufacturer> getManufacturersByIds(List<Long> manufacturerIds) {
        return manufacturerRepository.findAllById(manufacturerIds);
    }

    // Delete a manufacturer by ID
    @Transactional
    public boolean deleteManufacturer(Long id) {
        if (manufacturerRepository.existsById(id)) {
            manufacturerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
