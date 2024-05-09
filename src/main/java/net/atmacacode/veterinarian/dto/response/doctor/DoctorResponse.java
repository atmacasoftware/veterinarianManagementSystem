package net.atmacacode.veterinarian.dto.response.doctor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atmacacode.veterinarian.entities.AvailableDate;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {
    private long id;
    private String name;
    private String mail;
    private String phone;
    private String address;
    private String city;
    @JsonIgnore
    private List<AvailableDate> availableDateList;
}
