package net.atmacacode.veterinarian.dto.request.customer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerForAppointmentRequest {
    @NotNull(message = "Müşteri id boş olamaz!")
    private long id;
}
