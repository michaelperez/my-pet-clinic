package com.perezma.mypetclinic.bootstrap;

import com.perezma.mypetclinic.models.Owner;
import com.perezma.mypetclinic.models.PetType;
import com.perezma.mypetclinic.models.Vet;
import com.perezma.mypetclinic.services.OwnerService;
import com.perezma.mypetclinic.services.PetTypeService;
import com.perezma.mypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Jon");
        owner1.setLastName("Snow");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ramsey");
        owner2.setLastName("Bolton");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Emilia");
        vet1.setLastName("Edwards");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Liz");
        vet2.setLastName("Clarke");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
