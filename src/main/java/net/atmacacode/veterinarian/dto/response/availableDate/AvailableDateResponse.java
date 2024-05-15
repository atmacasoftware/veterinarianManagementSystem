package net.atmacacode.veterinarian.dto.response.availableDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import net.atmacacode.veterinarian.entities.Doctor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateResponse {
    private long id;
    private LocalDate availableDate;
    @JsonIgnore
    private Doctor doctor;
}
