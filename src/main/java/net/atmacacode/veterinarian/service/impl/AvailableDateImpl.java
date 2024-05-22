package net.atmacacode.veterinarian.service.impl;

import net.atmacacode.veterinarian.core.exception.NotFoundException;
import net.atmacacode.veterinarian.core.utilies.Msg;
import net.atmacacode.veterinarian.dao.AvailableDateRepo;
import net.atmacacode.veterinarian.dao.DoctorRepo;
import net.atmacacode.veterinarian.dto.request.availableDate.AvailableDateRequest;
import net.atmacacode.veterinarian.dto.response.availableDate.AvailableDateResponse;
import net.atmacacode.veterinarian.entities.AvailableDate;
import net.atmacacode.veterinarian.entities.Doctor;
import net.atmacacode.veterinarian.mapper.AvailableDateMapper;
import net.atmacacode.veterinarian.service.abstracts.AvailableDateService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AvailableDateImpl implements AvailableDateService {

    private final AvailableDateRepo availableDateRepo;
    private final AvailableDateMapper availableDateMapper;
    private final DoctorRepo doctorRepo;

    public AvailableDateImpl(AvailableDateRepo availableDateRepo, AvailableDateMapper availableDateMapper, DoctorRepo doctorRepo) {
        this.availableDateRepo = availableDateRepo;
        this.availableDateMapper = availableDateMapper;
        this.doctorRepo = doctorRepo;
    }

    @Override
    public AvailableDateResponse save(AvailableDateRequest request) {
        Optional<AvailableDate> isAvailableDateExists = availableDateRepo.findByAvailableDateAndDoctorId(request.getAvailableDate(), request.getDoctorId().getId());
        if (isAvailableDateExists.isEmpty()) {
            Doctor doctor = doctorRepo.findById(request.getDoctorId().getId()).orElseThrow(() -> new NotFoundException(Msg.notFound(request.getDoctorId().getId(), "doktor")));
            AvailableDate availableDate = new AvailableDate();
            availableDate.setDoctor(doctor);
            availableDate.setAvailableDate(request.getAvailableDate());

            AvailableDate availableDateSaved = availableDateRepo.save(availableDate);
            return availableDateMapper.asOutput(availableDateSaved);
        }
        System.out.println("mevcut");
        throw new RuntimeException(Msg.IsPossibilityRegistration("müsait tarih"));
    }

    @Override
    public AvailableDateResponse getAvailableDateById(long id) {
        return availableDateMapper.asOutput(availableDateRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.notFound(id, "müsait tarih"))));
    }

    @Override
    public List<AvailableDateResponse> getAll() {
        return this.availableDateMapper.asOutput(this.availableDateRepo.findAll());
    }

    @Override
    public List<AvailableDateResponse> getFilter(Long doctorId, LocalDate from, LocalDate to) {
        return availableDateMapper.asOutput(availableDateRepo.findByDoctorIdAndAvailableDateBetween(doctorId, from, to));
    }

    @Override
    public AvailableDateResponse update(long id, AvailableDateRequest request) {
        Optional<AvailableDate> availableDateFromDb = this.availableDateRepo.findById(id);
        if (availableDateFromDb.isEmpty()) {
            throw new NotFoundException(Msg.notFound(id, "müsait tarih"));
        }

        Doctor doctor = doctorRepo.findById(request.getDoctorId().getId()).orElseThrow(() -> new NotFoundException(Msg.notFound(request.getDoctorId().getId(), "doktor")));
        AvailableDate availableDate = availableDateFromDb.get();
        availableDate.setDoctor(doctor);
        availableDate.setAvailableDate(request.getAvailableDate());
        AvailableDate availableDateSaved = availableDateRepo.save(availableDate);
        return this.availableDateMapper.asOutput(availableDateSaved);
    }

    @Override
    public void deleteById(long id) {
        Optional<AvailableDate> availableDateFromDb = this.availableDateRepo.findById(id);
        if(availableDateFromDb.isPresent()) {
            this.availableDateRepo.delete(availableDateFromDb.get());
        }else{
            throw new NotFoundException(Msg.notFound(id, "müsait tarih"));
        }
    }
}
