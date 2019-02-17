package com.perezma.mypetclinic.services.map;

import com.perezma.mypetclinic.models.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    private final Long petId = 1L;
    private PetMapService petMapService;

    @BeforeEach
    void setUp() {

        petMapService = new PetMapService();

        Pet pet = new Pet();
        pet.setId(petId);
        petMapService.save(pet);
    }

    @Test
    void findAll() {

        Set<Pet> petSet = petMapService.findAll();

        assertEquals(1, petSet.size());
    }

    @Test
    void findByIdExistingId() {

        Pet pet = petMapService.findById(petId);

        assertEquals(petId, pet.getId());
    }

    @Test
    void findByIdNotExistingId() {

        Pet pet = petMapService.findById(5L);

        assertNull(pet);
    }

    @Test
    void findByIdNullId() {

        Pet pet = petMapService.findById(null);

        assertNull(pet);
    }

    @Test
    void saveExistingId() {

        Long id = 2L;

        Pet pet2 = new Pet();
        pet2.setId(id);
        Pet savedPet = petMapService.save(pet2);

        assertEquals(id, savedPet.getId());
    }

    @Test
    void saveDuplicateId() {

        Long id = 1L;

        Pet pet2 = new Pet();
        pet2.setId(id);
        Pet savedPet = petMapService.save(pet2);

        assertEquals(id, savedPet.getId());
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void saveNoId() {

        Pet savedPet = petMapService.save(new Pet());

        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
        assertEquals(2, petMapService.findAll().size());
    }

    @Test
    void deletePet() {

        petMapService.delete(petMapService.findById(petId));

        assertEquals(0, petMapService.findAll().size());

    }

    @Test
    void deleteWithWrongId() {

        Long id = 5L;
        Pet pet = new Pet();
        pet.setId(id);
        petMapService.delete(pet);

        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {

        petMapService.delete(new Pet());

        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteNull() {

        petMapService.delete(null);

        assertEquals(1, petMapService.findAll().size());

    }

    @Test
    void deleteByIdCorrectId() {

        petMapService.deleteById(petId);

        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteByIdWrongId() {

        petMapService.deleteById(5L);

        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteByIdNullId() {

        petMapService.deleteById(null);

        assertEquals(1, petMapService.findAll().size());
    }

}