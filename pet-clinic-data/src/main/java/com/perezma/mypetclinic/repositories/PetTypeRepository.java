package com.perezma.mypetclinic.repositories;

import com.perezma.mypetclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
