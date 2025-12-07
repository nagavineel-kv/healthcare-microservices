package com.hcm.patientservice.service;

import com.hcm.patientservice.dto.PatientResponseDTO;
import com.hcm.patientservice.mapper.PatientMapper;
import com.hcm.patientservice.model.Patient;
import com.hcm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOS = patients.stream()
                .map(patient -> PatientMapper.toDto(patient)).toList();
        return patientResponseDTOS;
    }
}
