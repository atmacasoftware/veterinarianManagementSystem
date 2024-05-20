package net.atmacacode.veterinarian.dto.request.vaccine;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalForVaccineRequest {
    @NotNull(message = "Hayvan id boş olamaz.")
    private long id;
}
