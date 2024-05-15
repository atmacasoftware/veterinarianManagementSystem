package net.atmacacode.veterinarian.mapper;

import net.atmacacode.veterinarian.dto.request.availableDate.AvailableDateRequest;
import net.atmacacode.veterinarian.dto.request.doctor.DoctorRequest;
import net.atmacacode.veterinarian.dto.response.availableDate.AvailableDateResponse;
import net.atmacacode.veterinarian.dto.response.doctor.DoctorResponse;
import net.atmacacode.veterinarian.entities.AvailableDate;
import net.atmacacode.veterinarian.entities.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AvailableDateMapper {

    AvailableDate asEntity(AvailableDateRequest availableDateRequest);

    AvailableDateResponse asOutput(AvailableDate availableDate);

    List<AvailableDateResponse> asOutput(List<AvailableDate> availableDate);

    void update(@MappingTarget AvailableDate availableDate, AvailableDateRequest availableDateRequest);
}
