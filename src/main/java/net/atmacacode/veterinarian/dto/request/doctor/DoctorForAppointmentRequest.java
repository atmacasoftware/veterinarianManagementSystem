package net.atmacacode.veterinarian.dto.request.doctor;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorForAppointmentRequest {
    @NotNull(message = "Doktor id olamaz.")
    private long id;
}
