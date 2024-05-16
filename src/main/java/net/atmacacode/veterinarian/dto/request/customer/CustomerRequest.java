package net.atmacacode.veterinarian.dto.request.customer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    @NotNull(message = "Müşteri ad-soyad boş olamaz")
    private String name;

    @NotNull(message = "Müşteri telefon numarası boş olamaz")
    private String phone;

    @NotNull(message = "Müşteri mail adresi boş olamaz")
    private String mail;

    private String address;

    private String city;
}
