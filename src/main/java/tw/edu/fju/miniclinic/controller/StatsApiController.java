package tw.edu.fju.miniclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.edu.fju.miniclinic.model.DoctorRepository;
import tw.edu.fju.miniclinic.model.PatientRepository;
import tw.edu.fju.miniclinic.model.StatsRepository;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StatsApiController {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private StatsRepository statsRepo;

    @GetMapping("/api/stats")
    public Map<String, Object> getSystemStats() {
        Map<String, Object> response = new HashMap<>();

        // 利用內建的 count() 方法取得總筆數
        response.put("totalDoctors", doctorRepo.count());
        response.put("totalPatients", patientRepo.count());
        response.put("totalAppointments", statsRepo.count());

        Map<String, Long> byStatus = new HashMap<>();
        byStatus.put("BOOKED", statsRepo.countByStatus("BOOKED"));
        byStatus.put("COMPLETED", statsRepo.countByStatus("COMPLETED"));
        byStatus.put("CANCELLED", statsRepo.countByStatus("CANCELLED"));

        response.put("byStatus", byStatus);
        return response;
    }
}