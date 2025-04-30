package com.armory.WeaponVault.delegate;

import com.armory.WeaponVault.entity.Manufacturer;
import com.armory.WeaponVault.entityDTO.ManufacturerDto;
import com.armory.WeaponVault.entityDTO.ManufacturerDtoInsert;
import com.armory.WeaponVault.organizationApi.ManufacturerApiDelegate;
import com.armory.WeaponVault.service.ManufacturerService;
import com.armory.WeaponVault.mapper.ManufacturerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManufacturerApiDelegateImpl implements ManufacturerApiDelegate {

    private static final Logger logger = LoggerFactory.getLogger(ManufacturerApiDelegateImpl.class);

    private final ManufacturerService manufacturerService;
    private final ManufacturerMapper manufacturerMapper;

    // Constructor injection
    @Autowired
    public ManufacturerApiDelegateImpl(ManufacturerService manufacturerService, ManufacturerMapper manufacturerMapper) {
        this.manufacturerService = manufacturerService;
        this.manufacturerMapper = manufacturerMapper;
    }

    // Create a new manufacturer
    @Override
    public ResponseEntity<ManufacturerDtoInsert> createManufacturer(String xTenantID, ManufacturerDtoInsert manufacturerDtoInsert) {
        try {
            // Check if a manufacturer with the same name already exists
            String name = manufacturerDtoInsert.getName().trim();
            Optional<Manufacturer> existingManufacturer = manufacturerService.getManufacturerByName(name);

            if (existingManufacturer.isPresent()) {
                logger.info("Manufacturer with name '{}' already exists. Returning conflict response.", name);
                return new ResponseEntity<>(manufacturerMapper.toManufacturerDtoInsert(existingManufacturer.get()), HttpStatus.CONFLICT);
            }

            // Convert ManufacturerDto to Manufacturer entity
            Manufacturer manufacturer = manufacturerMapper.toManufacturerEntityFromInsert(manufacturerDtoInsert);
            if (manufacturer.getCreatedAt() == null) {
                manufacturer.setCreatedAt(LocalDateTime.now());
            }
            manufacturer.setStatus("Active");
            // Save the manufacturer
            manufacturer = manufacturerService.saveManufacturer(manufacturer);
            ManufacturerDtoInsert responseDto = manufacturerMapper.toManufacturerDtoInsert(manufacturer);
            logger.info("Successfully created manufacturer with ID '{}'", manufacturer.getId());
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error occurred while creating manufacturer: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a manufacturer by ID
    @Override
    public ResponseEntity<Void> deleteManufacturer(Long manufacturerId, String xTenantID) {
        try {
            boolean isDeleted = manufacturerService.deleteManufacturer(manufacturerId);
            if (isDeleted) {
                logger.info("Successfully deleted manufacturer with ID '{}'", manufacturerId);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                logger.warn("Manufacturer with ID '{}' not found. Deletion failed.", manufacturerId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error occurred while deleting manufacturer with ID '{}': {}", manufacturerId, e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all manufacturers
    @Override
    public ResponseEntity<List<ManufacturerDto>> getAllManufacturers(String xTenantID) {
        try {
            List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
//            List<ManufacturerDto> responseDtos = manufacturers.stream()
//                    .map(manufacturerMapper::toManufacturerDto)
//                    .collect(Collectors.toList());
            List<ManufacturerDto> responseDtos = manufacturerMapper.toManufacturerDtoList(manufacturers);

            logger.info("Successfully retrieved {} manufacturers.", manufacturers.size());
            return new ResponseEntity<>(responseDtos, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while fetching all manufacturers: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get manufacturer by ID
    @Override
    public ResponseEntity<ManufacturerDto> getManufacturerById(Long manufacturerId, String xTenantID) {
        try {
            Optional<Manufacturer> manufacturer = manufacturerService.getManufacturerById(manufacturerId);
            if (manufacturer.isPresent()) {
                ManufacturerDto responseDto = manufacturerMapper.toManufacturerDto(manufacturer.get());
                logger.info("Successfully retrieved manufacturer with ID '{}'", manufacturerId);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } else {
                logger.warn("Manufacturer with ID '{}' not found.", manufacturerId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error occurred while fetching manufacturer with ID '{}': {}", manufacturerId, e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update a manufacturer by ID
    @Override
    public ResponseEntity<ManufacturerDtoInsert> updateManufacturer(Long manufacturerId, String xTenantID, ManufacturerDtoInsert manufacturerDtoInsert) {
        try {

            Optional<Manufacturer> existingManufacturer = manufacturerService.getManufacturerById(manufacturerId);


            if (existingManufacturer.isPresent()) {

//                Manufacturer manufacturer = manufacturerMapper.toManufacturerEntityFromInsert(manufacturerDtoInsert);
//
//                manufacturer.setId(manufacturerId);  // Ensure the correct ID for update
//                manufacturer.setUpdatedAt(LocalDateTime.now());
                System.out.println("Existing"+existingManufacturer);

                Manufacturer manufacturer = existingManufacturer.get();
                System.out.println(manufacturer+"Fetched");

                manufacturer.setId(manufacturerId);  // Ensure the correct ID for update
                manufacturer.setName(manufacturerDtoInsert.getName());
                manufacturer.setUpdatedAt(LocalDateTime.now());

                Manufacturer updatedManufacturer = manufacturerService.updateManufacturer(manufacturer);

                ManufacturerDtoInsert responseDto = manufacturerMapper.toManufacturerDtoInsert(updatedManufacturer);
                logger.info("Successfully updated manufacturer with ID '{}'", manufacturerId);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } else {
                logger.warn("Manufacturer with ID '{}' not found. Update failed.", manufacturerId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error occurred while updating manufacturer with ID '{}': {}", manufacturerId, e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
