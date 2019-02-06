package com.perezma.mypetclinic.services;

import java.util.Set;

public interface Vet {

    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
