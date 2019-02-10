package com.perezma.mypetclinic.bootstrap;

import com.perezma.mypetclinic.models.*;
import com.perezma.mypetclinic.services.OwnerService;
import com.perezma.mypetclinic.services.PetTypeService;
import com.perezma.mypetclinic.services.SpecialtyService;
import com.perezma.mypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void run(String... args) throws Exception {

        // Test if there is data in database before calling dataLoader.
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Jon");
        owner1.setLastName("Snow");
        owner1.setAddress("North Road");
        owner1.setCity("Winterfell");
        owner1.setTelephone("1-800-RAVEN");

        Pet jonPet = new Pet();
        jonPet.setName("Fang");
        jonPet.setPetType(savedDogPetType);
        jonPet.setBirthDate(LocalDate.now());
        jonPet.setOwner(owner1);
        owner1.getPets().add(jonPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sansa");
        owner2.setLastName("Stark");
        owner2.setAddress("North Road");
        owner2.setCity("Winterfell");
        owner2.setTelephone("1-800-RAVEN");

        Pet sansaPet = new Pet();
        sansaPet.setName("Snowball");
        sansaPet.setPetType(savedCatPetType);
        sansaPet.setBirthDate(LocalDate.now());
        sansaPet.setOwner(owner2);
        owner2.getPets().add(sansaPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Emilia");
        vet1.setLastName("Edwards");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Liz");
        vet2.setLastName("Clarke");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
