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


    public List<Hospital> getAllNurses(){
      return hospitalRepo.findAll();
    }

    public void saveNurse(@RequestBody Hospital hospital){
        String encodedPassword = bCryptPasswordEncoder.encode(hospital.getNursePassword());
        hospital.setNursePassword(encodedPassword);
        hospitalRepo.save(hospital);
    }

    public Optional<Hospital> getNurseByFirstName(@PathVariable String firstName){
       return hospitalRepo.getNurseByFirstName(firstName);
    }

    public void deleteNurse(@RequestBody Hospital hospital){
        hospitalRepo.delete(hospital);
    }

    public boolean updateNurse(@RequestBody Hospital hospital) {
        if (hospitalRepo.existsById(hospital.getNurseId())) {
            hospitalRepo.save(hospital);
            return true;
        } else {
            return false;
        }
    }
}
