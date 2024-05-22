package net.atmacacode.veterinarian.dto.request.animal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalForAppointmentRequest {
    @NotNull(message = "Hayvan ID boş olamaz")
    private long id;
}
