package net.atmacacode.veterinarian.dto.response.appointment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atmacacode.veterinarian.entities.Doctor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private long id;
    private LocalDateTime appoinmentDate;
    @JsonIgnore
    private Doctor doctor;
}
