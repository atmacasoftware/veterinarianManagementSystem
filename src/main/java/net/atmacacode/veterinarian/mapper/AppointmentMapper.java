package net.atmacacode.veterinarian.mapper;

import net.atmacacode.veterinarian.dto.request.appointment.AppointmentRequest;
import net.atmacacode.veterinarian.dto.response.appointment.AppointmentResponse;
import net.atmacacode.veterinarian.entities.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppointmentMapper {

    Appointment asEntity(AppointmentRequest appointmentRequest);

    AppointmentResponse asOutput(Appointment appointment);

    List<AppointmentResponse> asOutput(List<Appointment> appointment);

    void update(@MappingTarget Appointment appointment, AppointmentRequest appointmentRequest);
}
