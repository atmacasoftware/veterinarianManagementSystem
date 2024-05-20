package net.atmacacode.veterinarian.dao;

import net.atmacacode.veterinarian.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Long> {
    Optional<Vaccine> findByNameAndCodeAndAnimalId(String name, String code, long id);
    //Optional<Vaccine> findByCodeAndAnimalIdAndProtectionFinishDateAfter(String code, long id, LocalDate finishDate);
    Optional<Vaccine> findByCodeAndAnimalIdAndProtectionFinishDateAfter(String code, long id, LocalDate finishDate);
    List<Vaccine> findByAnimalId(long id);
    List<Vaccine> findByProtectionFinishDateBetween(LocalDate startDate, LocalDate finishDate);
}
