package net.atmacacode.veterinarian.dto.request.availableDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.atmacacode.veterinarian.dto.request.doctor.DoctorForAvailableDateRequest;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateRequest {
    @NotNull(message = "Müsait tarih bilgisi boş olamaz.")
    private LocalDate availableDate;

    @NotNull(message = "Doktor boş olamaz")
    private DoctorForAvailableDateRequest doctorId;
}
