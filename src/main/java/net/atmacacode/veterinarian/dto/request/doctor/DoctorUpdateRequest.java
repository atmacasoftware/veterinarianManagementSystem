package net.atmacacode.veterinarian.dto.request.doctor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorUpdateRequest {
    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private Long id;

    @NotNull(message = "Doktor adı boş olamaz.")
    private String name;

    @NotNull(message = "E-posta boş olamaz.")
    private String mail;

    @NotNull(message = "Telefon numarası boş olamaz.")
    private String phone;

    @NotNull(message = "Adres bilgisi boş olamaz.")
    private String address;

    @NotNull(message = "Şehir bilgisi boş olamaz.")
    private String city;
}
