package net.atmacacode.veterinarian.dto.request.animal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atmacacode.veterinarian.dto.request.customer.CustomerForAnimalRequest;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalRequest {
    @NotNull(message = "Hayvan adı boş olamaz!")
    private String name;

    @NotNull(message = "Hayvan türü boş olamaz!")
    private String species;

    @NotNull(message = "Hayvan yavrulama boş olamaz!")
    private String breed;

    @NotNull(message = "Hayvan cinsiyeti boş olamaz!")
    private String gender;

    @NotNull(message = "Hayvan rengi boş olamaz!")
    private String colour;

    @NotNull(message = "Hayvan doğum tarihi boş olamaz!")
    private LocalDate dateOfBirth;

    @NotNull(message = "Müşteri id boş olamaz!")
    private CustomerForAnimalRequest customerId;
}
