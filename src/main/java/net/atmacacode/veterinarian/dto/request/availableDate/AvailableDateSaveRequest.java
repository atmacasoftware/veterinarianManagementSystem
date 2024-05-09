package net.atmacacode.veterinarian.dto.request.availableDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateSaveRequest {
    @NotNull(message = "Müsait tarih bilgisi boş olamaz.")
    private LocalDate availableDate;

    @NotNull(message = "Doktor ID olamaz")
    private int doctorId;;
}
