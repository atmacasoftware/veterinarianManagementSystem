package net.atmacacode.veterinarian.service.impl;

import net.atmacacode.veterinarian.core.exception.NotFoundException;
import net.atmacacode.veterinarian.core.utilies.Msg;
import net.atmacacode.veterinarian.dao.*;
import net.atmacacode.veterinarian.dto.request.appointment.AppointmentRequest;
import net.atmacacode.veterinarian.dto.response.appointment.AppointmentResponse;
import net.atmacacode.veterinarian.entities.*;
import net.atmacacode.veterinarian.mapper.AppointmentMapper;
import net.atmacacode.veterinarian.service.abstracts.AppointmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentImpl implements AppointmentService {

    private final AppointmentRepo appointmentRepo;
    private final AppointmentMapper appointmentMapper;
    private final DoctorRepo doctorRepo;
    private final AvailableDateRepo availableDateRepo;
    private final CustomerRepo customerRepo;
    private final AnimalRepo animalRepo;

    public AppointmentImpl(AppointmentRepo appointmentRepo, AppointmentMapper appointmentMapper, DoctorRepo doctorRepo, AvailableDateRepo availableDateRepo, CustomerRepo customerRepo, AnimalRepo animalRepo) {
        this.appointmentRepo = appointmentRepo;
        this.appointmentMapper = appointmentMapper;
        this.doctorRepo = doctorRepo;
        this.availableDateRepo = availableDateRepo;
        this.customerRepo = customerRepo;
        this.animalRepo = animalRepo;
    }

    @Override
    public AppointmentResponse save(AppointmentRequest request) {

        Optional<Doctor> isDoctorExists = doctorRepo.findById(request.getDoctorId().getId());
        if (isDoctorExists.isEmpty()) {
            throw new NotFoundException(Msg.notFound(request.getDoctorId().getId(), "doktor"));
        }

        if(isDoctorExists.isPresent()){
            //Girilen tarihe doktorun uygun tarihi olup olmadığını sorgulamak için hazırlanan endpoint.
            Optional<AvailableDate> isAvailebleDateExists = availableDateRepo.findByAvailableDateAndDoctorId(request.getAppoinmentDate(), isDoctorExists.get().getId());
            if (isAvailebleDateExists.isEmpty()) {
                throw new NotFoundException(Msg.notFound(isDoctorExists.get().getId(), "doktor'a ait randevu"));
            }

            String str = "";
            if(request.getAppoinmentHour() >= 0 && request.getAppoinmentHour() < 10){
                str = String.valueOf(request.getAppoinmentDate()) + "T0" + String.valueOf(request.getAppoinmentHour()) + ":00:00Z";
            } else if (request.getAppoinmentHour() >= 10 && request.getAppoinmentHour() <=24) {
                str = String.valueOf(request.getAppoinmentDate()) + "T" + String.valueOf(request.getAppoinmentHour()) + ":00:00Z";
            } else{
                throw new NumberFormatException();
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
            LocalDateTime localDateTime = LocalDateTime.parse(str,formatter);

            //Doktorun ilgili randevu tarih ve saatine randevu alınıp alınmadığını sorgulamak için hazırlanan endpoint.
            Optional<Appointment> isAppointmentExists = appointmentRepo.findByDoctorIdAndAppoinmentDate(request.getDoctorId().getId(), localDateTime);

            //Müşterinin daha önce ilgili hayvana aynı randevuyu alıp almadığını sorgulamak için hazırlanan endpoint.
            Optional<Appointment> isCustomerAndAnimalExists = appointmentRepo.findByCustomerIdAndAnimalIdAndAppoinmentDate(request.getCustomerId().getId(), request.getAnimalId().getId(), localDateTime);

            if(isCustomerAndAnimalExists.isPresent() || isAppointmentExists.isPresent()){
                throw new RuntimeException(Msg.IsPossibilityRegistration("randevu"));
            }

            Doctor doctor = isDoctorExists.get();
            Customer customer = customerRepo.findById(request.getCustomerId().getId()).orElseThrow(() -> new NotFoundException(Msg.notFound(request.getCustomerId().getId(), "müşteri")));
            Animal animal = animalRepo.findById(request.getAnimalId().getId()).orElseThrow(() -> new NotFoundException(Msg.notFound(request.getAnimalId().getId(), "hayvan")));
            Appointment appointment = new Appointment();
            appointment.setDoctor(doctor);
            appointment.setCustomer(customer);
            appointment.setAnimal(animal);
            appointment.setAppoinmentDate(localDateTime);

            Appointment appointmentSaved = appointmentRepo.save(appointment);
            return appointmentMapper.asOutput(appointmentSaved);
        }

        throw new RuntimeException(Msg.IsPossibilityRegistration("randevu"));
    }

    @Override
    public AppointmentResponse getAppointmentById(long id) {
        return appointmentMapper.asOutput(appointmentRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.notFound(id, "randevu"))));
    }

    @Override
    public List<AppointmentResponse> getAll() {
        return appointmentMapper.asOutput(appointmentRepo.findAll());
    }

    @Override
    public List<AppointmentResponse> getFilter(Long animalId, LocalDate startDate, LocalDate endDate) {
        return appointmentMapper.asOutput(appointmentRepo.findByAnimalIdAndAppoinmentDateBetween(animalId, LocalDateTime.of(startDate, LocalTime.MIN), LocalDateTime.of(endDate, LocalTime.MIN)));
    }

    @Override
    public AppointmentResponse update(long id, AppointmentRequest request) {
        Optional<Appointment> appointmentExists = appointmentRepo.findById(id);
        if (appointmentExists.isEmpty()){
            throw new NotFoundException(Msg.notFound(id, "randevu"));
        }

        String str = "";
        if(request.getAppoinmentHour() >= 0 && request.getAppoinmentHour() < 10){
            str = String.valueOf(request.getAppoinmentDate()) + "T0" + String.valueOf(request.getAppoinmentHour()) + ":00:00Z";
        } else if (request.getAppoinmentHour() >= 10 && request.getAppoinmentHour() <=24) {
            str = String.valueOf(request.getAppoinmentDate()) + "T" + String.valueOf(request.getAppoinmentHour()) + ":00:00Z";
        } else{
            throw new NumberFormatException();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        LocalDateTime localDateTime = LocalDateTime.parse(str,formatter);

        Doctor doctor = doctorRepo.findById(request.getDoctorId().getId()).orElseThrow(() -> new NotFoundException(Msg.notFound(request.getDoctorId().getId(), "doktor")));
        Customer customer = customerRepo.findById(request.getCustomerId().getId()).orElseThrow(() -> new NotFoundException(Msg.notFound(request.getCustomerId().getId(), "müşteri")));
        Animal animal = animalRepo.findById(request.getAnimalId().getId()).orElseThrow(() -> new NotFoundException(Msg.notFound(request.getAnimalId().getId(), "hayvan")));
        Appointment appointment = appointmentExists.get();
        appointment.setDoctor(doctor);
        appointment.setCustomer(customer);
        appointment.setAnimal(animal);
        appointment.setAppoinmentDate(localDateTime);
        Appointment appointmentSaved = appointmentRepo.save(appointment);
        return appointmentMapper.asOutput(appointmentSaved);
    }

    @Override
    public void deleteById(long id) {
        Optional<Appointment> appointmentFromDb = appointmentRepo.findById(id);

        if(appointmentFromDb.isPresent()) {
            appointmentRepo.delete(appointmentFromDb.get());
        }else{
            throw new NotFoundException(Msg.notFound(id, "randevu"));
        }
    }
}
