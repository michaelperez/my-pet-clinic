package com.perezma.mypetclinic.repositories;

import com.perezma.mypetclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
