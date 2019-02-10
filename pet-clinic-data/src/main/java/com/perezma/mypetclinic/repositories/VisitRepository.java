package com.perezma.mypetclinic.repositories;

import com.perezma.mypetclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
