package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByMail(String email);
    boolean existsByMail(String email);
}
