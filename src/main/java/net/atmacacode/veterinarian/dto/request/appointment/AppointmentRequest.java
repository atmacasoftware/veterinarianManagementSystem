package net.atmacacode.veterinarian.dto.request.appointment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atmacacode.veterinarian.dto.request.animal.AnimalForAppointmentRequest;
import net.atmacacode.veterinarian.dto.request.customer.CustomerForAnimalRequest;
import net.atmacacode.veterinarian.dto.request.customer.CustomerForAppointmentRequest;
import net.atmacacode.veterinarian.dto.request.doctor.DoctorForAppointmentRequest;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {
    @NotNull(message = "Randevu tarih bilgisi boş olamaz!")
    private LocalDate appoinmentDate;

    @NotNull(message = "Randevu saat bilgisi boş olamaz!")
    private int appoinmentHour;

    @NotNull(message = "Doktor ID boş olamaz!")
    private DoctorForAppointmentRequest doctorId;

    @NotNull(message = "Müşteri ID boş olamaz!")
    private CustomerForAppointmentRequest customerId;

    @NotNull(message = "Hayvan ID boş olamaz!")
    private AnimalForAppointmentRequest animalId;

}
