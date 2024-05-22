package net.atmacacode.veterinarian.mapper;

import net.atmacacode.veterinarian.dto.request.doctor.DoctorRequest;
import net.atmacacode.veterinarian.dto.response.doctor.DoctorResponse;
import net.atmacacode.veterinarian.entities.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DoctorMapper {

    Doctor asEntity(DoctorRequest doctorRequest);

    DoctorResponse asOutput(Doctor doctor);

    List<DoctorResponse> asOutput(List<Doctor> doctor);

    void update(@MappingTarget Doctor doctor, DoctorRequest doctorRequest);

}
