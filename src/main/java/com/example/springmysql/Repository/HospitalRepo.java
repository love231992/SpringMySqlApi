package com.example.springmysql.Repository;

import com.example.springmysql.Dto.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital,Integer> {

    @Query("SELECT nu from Hospital nu where nu.nurseFirstName = ?1")
    Optional<Hospital> getNurseByFirstName(String firstName);
}
