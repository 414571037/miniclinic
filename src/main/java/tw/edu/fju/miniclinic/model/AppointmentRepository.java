package tw.edu.fju.miniclinic.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByApptDate(LocalDate apptDate);

    List<Appointment> findByDoctor(Doctor doctor);

    // 支援直接透過 ID 字串查詢掛號
    List<Appointment> findByDoctorDoctorId(String doctorId);

    List<Appointment> findByPatient(Patient patient);

    long countByApptDateBetween(LocalDate from, LocalDate to);

    List<Appointment> findByDoctorAndApptDate(Doctor doctor, LocalDate apptDate);  // 新加入

    // 統計各科別掛號數：透過關聯的 Doctor 物件取得 department 並分組計數
    @Query("SELECT d.department, COUNT(a) FROM Appointment a JOIN a.doctor d GROUP BY d.department")
    List<Object[]> countAppointmentsByDepartment();
}