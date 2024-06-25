package com.example.springmysql.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer nurseId;
    private String nurseFirstName;
    private String nurseLastName;
    private String nursePassword;
    private String nursePhoneNo;
    private Double nurseSalary;


}
