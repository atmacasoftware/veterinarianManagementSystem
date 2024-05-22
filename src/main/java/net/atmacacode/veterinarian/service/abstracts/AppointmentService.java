package net.atmacacode.veterinarian.service.abstracts;

import net.atmacacode.veterinarian.dto.request.appointment.AppointmentRequest;
import net.atmacacode.veterinarian.dto.response.appointment.AppointmentResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AppointmentService {
    AppointmentResponse save(AppointmentRequest request);

    AppointmentResponse getAppointmentById(long id);

    List<AppointmentResponse> getAll();

    List<AppointmentResponse> getFilter(Long animalId, LocalDate startDate, LocalDate endDate);

    AppointmentResponse update(long id, AppointmentRequest request);

    void deleteById(long id);
}
