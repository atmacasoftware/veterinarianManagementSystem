package net.atmacacode.veterinarian.service.impl;

import net.atmacacode.veterinarian.core.exception.NotFoundException;
import net.atmacacode.veterinarian.core.utilies.Msg;
import net.atmacacode.veterinarian.dao.DoctorRepo;
import net.atmacacode.veterinarian.entities.Doctor;
import net.atmacacode.veterinarian.service.abstracts.IDoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DoctorImpl implements IDoctorService {

    private final DoctorRepo doctorRepo;

    public DoctorImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return this.doctorRepo.save(doctor);
    }

    @Override
    public Doctor getUserById(int id) {
        return this.doctorRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.notFound(id)));
    }

    @Override
    public Page<Doctor> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.doctorRepo.findAll(pageable);
    }

    @Override
    public Doctor update(Doctor doctor) {
        this.getUserById(doctor.getId());
        return this.doctorRepo.save(doctor);
    }

    @Override
    public boolean delete(int id) {
        Doctor doctor = this.getUserById(id);
        this.doctorRepo.delete(doctor);
        return true;
    }
}
