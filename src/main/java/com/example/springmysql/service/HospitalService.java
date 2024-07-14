package com.example.springmysql.service;


import com.example.springmysql.Dto.Hospital;
import com.example.springmysql.Repository.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    HospitalRepo hospitalRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

// Method to get all the hospital data from MySql database with help of Spring data Jpa
    public List<Hospital> getAllNurses(){
      return hospitalRepo.findAll();
    }

    // Method to save the hospital data in MySql database with help of Spring data Jpa.
//    The password is encoded using Bcrypt encoder and then saved in db
    public void saveNurse(@RequestBody Hospital hospital){
        String encodedPassword = bCryptPasswordEncoder.encode(hospital.getNursePassword());
        hospital.setNursePassword(encodedPassword);
        hospitalRepo.save(hospital);
    }

//    Method to get the nurse data by nurse first name
    public Optional<Hospital> getNurseByFirstName(@PathVariable String firstName){
       return hospitalRepo.getNurseByFirstName(firstName);
    }

    // Method to delete a hospital entry from the db
    public void deleteNurse(@RequestBody Hospital hospital){
        hospitalRepo.delete(hospital);
    }

//     Method to update hospital entry in the db
    public boolean updateNurse(@RequestBody Hospital hospital) {
        if (hospitalRepo.existsById(hospital.getNurseId())) {
            hospitalRepo.save(hospital);
            return true;
        } else {
            return false;
        }
    }
}
