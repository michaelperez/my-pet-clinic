package com.perezma.mypetclinic.repositories;

import com.perezma.mypetclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
