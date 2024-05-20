package net.atmacacode.veterinarian.mapper;

import net.atmacacode.veterinarian.dto.request.vaccine.VaccineRequest;
import net.atmacacode.veterinarian.dto.response.vaccine.VaccineResponse;
import net.atmacacode.veterinarian.entities.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VaccineMapper {
    Vaccine asEntity(VaccineRequest vaccineRequest);

    VaccineResponse asOutput(Vaccine vaccine);

    List<VaccineResponse> asOutput(List<Vaccine> vaccines);

    void update(@MappingTarget Vaccine vaccine, VaccineRequest vaccineRequest);
}
