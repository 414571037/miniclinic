package tw.edu.fju.miniclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import tw.edu.fju.miniclinic.model.Patient;
import tw.edu.fju.miniclinic.model.PatientRepository;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // 頁面
    @GetMapping("/patients")
    public String patientsPage(Model model) {

        List<Patient> patients = patientRepository.findAll();

        model.addAttribute("patients", patients);

        return "patients";
    }
}