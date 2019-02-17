package com.perezma.mypetclinic.controllers;

import com.perezma.mypetclinic.models.Owner;
import com.perezma.mypetclinic.models.Pet;
import com.perezma.mypetclinic.models.PetType;
import com.perezma.mypetclinic.services.PetService;
import com.perezma.mypetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {
    private static final String PETS_CREATE_OR_UPDATE_VISIT_FORM = "pets/createOrUpdateVisitForm";
    private static final String REDIRECT_OWNERS_1 = "redirect:/owners/{ownerId}";
    private static final String YET_ANOTHER_VISIT_DESCRIPTION = "yet another visit";
    private final UriTemplate visitsUriTemplate = new UriTemplate("/owners/{ownerId}/pets/{petId}/visits/new");
    private final Map<String, String> uriVariables = new HashMap<>();
    @Mock
    PetService petService;
    @Mock
    VisitService visitService;
    @InjectMocks
    VisitController visitController;
    private MockMvc mockMvc;
    private URI visitsUri;

    @BeforeEach
    void setUp() {
        Long petId = 1L;
        Long ownerId = 1L;

        PetType petType1 = new PetType();
        petType1.setId(1L);
        petType1.setName("Dog");

        PetType petType2 = new PetType();
        petType2.setId(2L);
        petType2.setName("Cat");

        Set<PetType> petTypes = new HashSet<>();
        petTypes.add(petType1);
        petTypes.add(petType2);

        Pet pet = new Pet();
        pet.setName("Fang Dos");
        pet.setPetType(petType1);
        pet.setBirthDate(LocalDate.now());
        pet.setVisits(new HashSet<>());

        Owner owner = new Owner();
        owner.setId(1L);
        owner.getPets().add(pet);

        pet.setOwner(owner);

        when(petService.findById(anyLong()))
                .thenReturn(pet);

        uriVariables.clear();
        uriVariables.put("ownerId", ownerId.toString());
        uriVariables.put("petId", petId.toString());
        visitsUri = visitsUriTemplate.expand(uriVariables);

        mockMvc = MockMvcBuilders
                .standaloneSetup(visitController)
                .build();
    }

    @Test
    void initNewVisitForm() throws Exception {
        mockMvc.perform(get(visitsUri))
                .andExpect(status().isOk())
                .andExpect(view().name(PETS_CREATE_OR_UPDATE_VISIT_FORM))
        ;
    }


    @Test
    void processNewVisitForm() throws Exception {
        mockMvc.perform(post(visitsUri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("date", "2018-11-11")
                .param("description", YET_ANOTHER_VISIT_DESCRIPTION))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(REDIRECT_OWNERS_1))
                .andExpect(model().attributeExists("visit"))
        ;
    }
}