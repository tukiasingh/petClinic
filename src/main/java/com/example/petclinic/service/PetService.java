package com.example.petclinic.service;

import com.example.petclinic.model.Pet;
import com.example.petclinic.model.Response;
import com.example.petclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    public String getPetDetails() {
        petRepository.findAll();
        return petRepository.findAll().toString();
    }

    public ResponseEntity<Response> addPet(Pet pet) {
        try {
            Pet p = new Pet();
            p.setPetName(pet.getPetName());
            p.setPetOwner(pet.getPetOwner());

            petRepository.save(p);
            Optional<Pet> result = petRepository.findById(pet.getPetId());
            String petDetails ="";
            if (result.isPresent()) {
                petDetails = result.get().toString();
            }

            String message = "Pet added successfully:" + petDetails;
            int code = 200;

            Response response = new Response(code, message);
            System.out.println("Response is: " + response);
            return new ResponseEntity<Response>(response,HttpStatus.OK);


        } catch (Exception e) {
            String message = "Pet" + pet.getPetName() +"cannot be added";
            System.out.println("Exception is: " + e);

            int code = 500;
            Response response = new Response(code, message);
            return  new ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Response> getPets() {

        List<Pet> pets = new ArrayList<>();
        try {
            pets = petRepository.findAll();
            int code = 200;
            String message = "Pets Details retrieved successfully";
            Response response = new Response(code, message, pets);
            return  new ResponseEntity<Response>(response,HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Exception is: " + e);
            int code = 500;
            String message = "Pets Details cannot be retrieved";
            Response response = new Response(code, message,pets);
            return  new ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);


        }
    }




}
