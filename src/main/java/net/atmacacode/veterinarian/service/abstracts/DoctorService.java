package net.atmacacode.veterinarian.service.abstracts;

import net.atmacacode.veterinarian.dto.request.doctor.DoctorRequest;
import net.atmacacode.veterinarian.dto.response.doctor.DoctorResponse;
import net.atmacacode.veterinarian.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {

    DoctorResponse save(DoctorRequest request);

    DoctorResponse getUserById(long id);

    List<DoctorResponse> getAll();

    DoctorResponse update(long id, DoctorRequest request);

    void deleteById(long id);
}
