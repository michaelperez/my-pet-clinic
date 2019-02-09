package com.perezma.mypetclinic.bootstrap;

import com.perezma.mypetclinic.models.Owner;
import com.perezma.mypetclinic.models.Vet;
import com.perezma.mypetclinic.services.OwnerService;
import com.perezma.mypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Jon");
        owner1.setLastName("Snow");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Ramsey");
        owner2.setLastName("Bolton");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Emilia");
        vet1.setLastName("Edwards");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Liz");
        vet2.setLastName("Clarke");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
