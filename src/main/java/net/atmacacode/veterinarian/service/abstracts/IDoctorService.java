package net.atmacacode.veterinarian.service.abstracts;

import net.atmacacode.veterinarian.entities.Doctor;
import org.springframework.data.domain.Page;

public interface IDoctorService {
    Doctor save(Doctor doctor);

    Doctor getUserById(int id);

    Page<Doctor> cursor(int page, int pageSize);

    Doctor update(Doctor doctor);

    boolean delete(int id);
}
