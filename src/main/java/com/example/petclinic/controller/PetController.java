package com.example.petclinic.controller;


import com.example.petclinic.model.Pet;
import com.example.petclinic.model.Response;
import com.example.petclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path="/petClinic")
public class PetController {

    @Autowired
    PetService petService;

    @PostMapping(path="/addPet")
    public String addPet(@RequestParam String petName, @RequestParam String petOwner, Model page) {
        Pet pet = new Pet();
        pet.setPetName(petName);
        pet.setPetOwner(petOwner);
        ResponseEntity<Response> response = petService.addPet(pet);
        page.addAttribute("pet", pet);
        return "success.html";
    }

    @GetMapping(path ="/findPetDetails")
    public String findPets(Model page) {
        ResponseEntity<Response> response = petService.getPets();
        page.addAttribute("pets", response.getBody().getPets());
        return "getPetDetails.html";


    }

    @GetMapping(path="/addPetDetails")
    public String addPetDetails (Model page) {
//        List<String> cabs = bookCabService.allCabs();
//        page.addAttribute("cabs", cabs);
        return "addPetDetails.html";

    }

    @GetMapping(path="/getPetDetails")
    public String getPetDetails (Model page) {
//        List<String> cabs = bookCabService.allCabs();
//        page.addAttribute("cabs", cabs);
        return "getPetDetails.html";

    }
}
