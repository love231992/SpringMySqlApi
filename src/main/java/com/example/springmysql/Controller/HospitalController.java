package com.example.springmysql.Controller;

import com.example.springmysql.Dto.Hospital;
import com.example.springmysql.Repository.HospitalRepo;
import com.example.springmysql.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HospitalController {

    @Autowired
    HospitalService hospitalService;

    @GetMapping("/allNurses")
    public List<Hospital> getAllNurses(){
        return hospitalService.getAllNurses();
    }

    @PostMapping("/saveNurse")
    public ResponseEntity<String> saveNurse(@RequestBody Hospital hospital){
        hospitalService.saveNurse(hospital);
        return ResponseEntity.status(200).body("Nurse data has been saved");
    }

    @GetMapping("/getNurseByFirstName/{firstName}")
    public Optional<Hospital> getNurseByFirstName(@PathVariable String firstName){
       return hospitalService.getNurseByFirstName(firstName);
    }

    @DeleteMapping("/deleteNurse")
    public ResponseEntity<String> deleteNurse(@RequestBody Hospital hospital){
        hospitalService.deleteNurse(hospital);
        return ResponseEntity.status(200).body("Nurse has been deleted");
    }

    @PatchMapping("/updateNurse")
    public ResponseEntity<String> updateNurse(@RequestBody Hospital hospital){
        if (hospitalService.updateNurse(hospital)){
            return ResponseEntity.status(200).body("Nurse data has been updated");
        }
        else {
            return ResponseEntity.status(203).body("Nurse with id "+ hospital.getNurseId()+" does not exists.");
        }
    }
}
