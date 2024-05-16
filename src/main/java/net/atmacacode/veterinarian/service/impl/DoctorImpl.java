package net.atmacacode.veterinarian.service.impl;

import net.atmacacode.veterinarian.core.exception.NotFoundException;
import net.atmacacode.veterinarian.core.result.ResultData;
import net.atmacacode.veterinarian.core.utilies.Msg;
import net.atmacacode.veterinarian.dao.DoctorRepo;
import net.atmacacode.veterinarian.dto.request.doctor.DoctorRequest;
import net.atmacacode.veterinarian.dto.response.doctor.DoctorResponse;
import net.atmacacode.veterinarian.entities.Doctor;
import net.atmacacode.veterinarian.mapper.DoctorMapper;
import net.atmacacode.veterinarian.service.abstracts.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorImpl implements DoctorService {

    private final DoctorRepo doctorRepo;

    private final DoctorMapper doctorMapper;

    public DoctorImpl(DoctorRepo doctorRepo, DoctorMapper doctorMapper) {
        this.doctorRepo = doctorRepo;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public DoctorResponse save(DoctorRequest request) {
        Optional<Doctor> isDoctorExist = doctorRepo.findByMail(request.getMail());
        if(isDoctorExist.isEmpty()){
            Doctor doctorSaved = doctorRepo.save(doctorMapper.asEntity(request));
            return doctorMapper.asOutput(doctorSaved);
        }
        throw new RuntimeException(Msg.IsPossibilityRegistration("doktor"));
    }

    @Override
    public DoctorResponse getUserById(long id) {
        return doctorMapper.asOutput(doctorRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.notFound(id, "doktor"))));
    }

    @Override
    public List<DoctorResponse> getAll() {
        return this.doctorMapper.asOutput(this.doctorRepo.findAll());
    }

    @Override
    public DoctorResponse update(long id, DoctorRequest request) {
        Optional<Doctor> doctorFromDb = doctorRepo.findById(id);
        if(doctorFromDb.isEmpty()){
            throw new NotFoundException(Msg.notFound(id, "doktor"));
        }
        Doctor doctor = doctorFromDb.get();
        this.doctorMapper.update(doctor, request);
        return this.doctorMapper.asOutput(this.doctorRepo.save(doctor));
    }

    @Override
    public void deleteById(long id) {
        Optional<Doctor> doctorFromDb = this.doctorRepo.findById(id);
        if(doctorFromDb.isPresent()){
            this.doctorRepo.delete(doctorFromDb.get());
        }else{
            throw new NotFoundException(Msg.notFound(id, "doktor"));
        }
    }

}
