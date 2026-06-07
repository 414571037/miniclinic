package tw.edu.fju.miniclinic.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Appointment, Long> {
    long countByStatus(String status);
}