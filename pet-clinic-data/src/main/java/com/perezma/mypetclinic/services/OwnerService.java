package com.perezma.mypetclinic.services;

import com.perezma.mypetclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
