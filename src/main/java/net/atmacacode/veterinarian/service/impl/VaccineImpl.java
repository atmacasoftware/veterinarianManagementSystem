package net.atmacacode.veterinarian.service.impl;

import net.atmacacode.veterinarian.core.exception.NotFoundException;
import net.atmacacode.veterinarian.core.utilies.Msg;
import net.atmacacode.veterinarian.dao.AnimalRepo;
import net.atmacacode.veterinarian.dao.VaccineRepo;
import net.atmacacode.veterinarian.dto.request.vaccine.VaccineRequest;
import net.atmacacode.veterinarian.dto.response.vaccine.VaccineResponse;
import net.atmacacode.veterinarian.entities.Animal;
import net.atmacacode.veterinarian.entities.Vaccine;
import net.atmacacode.veterinarian.mapper.AnimalMapper;
import net.atmacacode.veterinarian.mapper.VaccineMapper;
import net.atmacacode.veterinarian.service.abstracts.AnimalService;
import net.atmacacode.veterinarian.service.abstracts.VaccineService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineImpl implements VaccineService {

    private final VaccineRepo vaccineRepo;
    private final VaccineMapper vaccineMapper;
    private final AnimalRepo animalRepo;

    public VaccineImpl(VaccineRepo vaccineRepo, VaccineMapper vaccineMapper, AnimalRepo animalRepo) {
        this.vaccineRepo = vaccineRepo;
        this.vaccineMapper = vaccineMapper;
        this.animalRepo = animalRepo;
    }

    @Override
    public VaccineResponse save(VaccineRequest request) {
        //Optional<Vaccine> isVaccineExists = vaccineRepo.findByNameAndCodeAndAnimalId(request.getName(), request.getCode(), request.getAnimalId().getId());
        //Optional<Vaccine> isCodeExists = vaccineRepo.findByCodeAndAnimalIdAndProtectionFinishDateAfter(request.getCode(),request.getAnimalId().getId(), request.getProtectionStartDate());
        Optional<Vaccine> isVaccineExists = vaccineRepo.findByCodeAndAnimalIdAndProtectionFinishDateAfter(request.getCode(), request.getAnimalId().getId(), request.getProtectionStartDate());

        if (isVaccineExists.isEmpty()) {
            Animal animal = animalRepo.findById(request.getAnimalId().getId()).orElseThrow(() -> new NotFoundException(Msg.notFound(request.getAnimalId().getId(), "hayvan")));
            Vaccine vaccine = new Vaccine();
            vaccine.setName(request.getName());
            vaccine.setCode(request.getCode());
            vaccine.setProtectionStartDate(request.getProtectionStartDate());
            vaccine.setProtectionFinishDate(request.getProtectionFinishDate());
            vaccine.setAnimal(animal);
            Vaccine vaccineSaved = vaccineRepo.save(vaccine);
            return vaccineMapper.asOutput(vaccineSaved);
        }

        //if (isCodeExists.isEmpty()) {
        //    System.out.println("deneme");
        //    Animal animal = animalRepo.findById(request.getAnimalId().getId()).orElseThrow(() -> new NotFoundException(Msg.notFound(request.getAnimalId().getId(), "hayvan")));
        //    Vaccine vaccine = new Vaccine();
        //    vaccine.setName(request.getName());
        //    vaccine.setCode(request.getCode());
        //    vaccine.setProtectionStartDate(request.getProtectionStartDate());
        //    vaccine.setProtectionFinishDate(request.getProtectionFinishDate());
        //    vaccine.setAnimal(animal);
        //    Vaccine vaccineSaved = vaccineRepo.save(vaccine);
        //    return vaccineMapper.asOutput(vaccineSaved);
        //}
//
        //if(!isVaccineExists.isEmpty()) {
        //    System.out.println("deneme");
        //}

        //if (isVaccineExists.isEmpty()) {
        //    Animal animal = animalRepo.findById(request.getAnimalId().getId()).orElseThrow(() -> new NotFoundException(Msg.notFound(request.getAnimalId().getId(), "hayvan")));
        //    Vaccine vaccine = new Vaccine();
        //    vaccine.setName(request.getName());
        //    vaccine.setCode(request.getCode());
        //    vaccine.setProtectionStartDate(request.getProtectionStartDate());
        //    vaccine.setProtectionFinishDate(request.getProtectionFinishDate());
        //    vaccine.setAnimal(animal);
        //    Vaccine vaccineSaved = vaccineRepo.save(vaccine);
        //    return vaccineMapper.asOutput(vaccineSaved);
        //}
//
        //if(isVaccineExists.isPresent()){
        //    System.out.println("asdfasdf");
        //    long days = Duration.between(isVaccineExists.get().getProtectionFinishDate(), request.getProtectionStartDate()).toDays();
        //    System.out.println(days);
        //}
//
        //if(isVaccineExists.isPresent()){
        //    System.out.println(isVaccineExists.get().getId());
        //}

        throw new RuntimeException(Msg.IsPossibilityRegistration("aşı"));
    }

    @Override
    public VaccineResponse getVaccineById(long id) {
        return vaccineMapper.asOutput(vaccineRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.notFound(id, "aşı"))));
    }

    @Override
    public List<VaccineResponse> getAll(Long id) {
        if (id != null) {
            return this.vaccineMapper.asOutput(vaccineRepo.findByAnimalId(id));
        }
        return this.vaccineMapper.asOutput(vaccineRepo.findAll());
    }

    @Override
    public List<VaccineResponse> getDateFilter(LocalDate startDate, LocalDate endDate) {
        return vaccineMapper.asOutput(vaccineRepo.findByProtectionFinishDateBetween(startDate, endDate));
    }

    @Override
    public VaccineResponse update(long id, VaccineRequest request) {
        Optional<Vaccine> vaccineFromDb = vaccineRepo.findById(id);
        if (vaccineFromDb.isEmpty()) {
            throw new NotFoundException(Msg.notFound(id, "aşı"));
        }

        Animal animal = animalRepo.findById(request.getAnimalId().getId()).orElseThrow(() -> new NotFoundException(Msg.notFound(request.getAnimalId().getId(), "hayvan")));
        Vaccine vaccine = vaccineFromDb.get();
        vaccine.setName(request.getName());
        vaccine.setCode(request.getCode());
        vaccine.setProtectionStartDate(request.getProtectionStartDate());
        vaccine.setProtectionFinishDate(request.getProtectionFinishDate());
        vaccine.setAnimal(animal);
        Vaccine vaccineSaved = vaccineRepo.save(vaccine);
        return vaccineMapper.asOutput(vaccineSaved);
    }

    @Override
    public void deleteById(long id) {
        Optional<Vaccine> vaccineFromDb = vaccineRepo.findById(id);
        if (vaccineFromDb.isPresent()) {
            vaccineRepo.delete(vaccineFromDb.get());
        } else {
            throw new NotFoundException(Msg.notFound(id, "aşı"));
        }
    }
}
