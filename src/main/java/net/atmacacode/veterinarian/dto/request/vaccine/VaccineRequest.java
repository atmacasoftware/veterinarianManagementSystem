package net.atmacacode.veterinarian.dto.request.vaccine;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineRequest {
    @NotNull(message = "Aşı adı boş olamaz!")
    private String name;

    @NotNull(message = "Aşı kodu boş olamaz!")
    private String code;

    @NotNull(message = "Aşı koruyuculuk başlangıç tarihi boş olamaz!")
    private LocalDate protectionStartDate;

    @NotNull(message = "Aşı koruyuculuk bitiş tarihi boş olamaz!")
    private LocalDate protectionFinishDate;

    @NotNull(message = "Hayvan ID boş olamaz!")
    private AnimalForVaccineRequest animalId;
}
