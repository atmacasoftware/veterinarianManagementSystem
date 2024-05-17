package net.atmacacode.veterinarian.service.impl;

import net.atmacacode.veterinarian.core.exception.NotFoundException;
import net.atmacacode.veterinarian.core.utilies.Msg;
import net.atmacacode.veterinarian.dao.AnimalRepo;
import net.atmacacode.veterinarian.dao.CustomerRepo;
import net.atmacacode.veterinarian.dto.request.animal.AnimalRequest;
import net.atmacacode.veterinarian.dto.response.animal.AnimalResponse;
import net.atmacacode.veterinarian.entities.Animal;
import net.atmacacode.veterinarian.entities.Customer;
import net.atmacacode.veterinarian.mapper.AnimalMapper;
import net.atmacacode.veterinarian.service.abstracts.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalImpl implements AnimalService {

    private final AnimalRepo animalRepo;
    private final AnimalMapper animalMapper;
    private final CustomerRepo customerRepo;

    public AnimalImpl(AnimalRepo animalRepo, AnimalMapper animalMapper, CustomerRepo customerRepo) {
        this.animalRepo = animalRepo;
        this.animalMapper = animalMapper;
        this.customerRepo = customerRepo;
    }


    @Override
    public AnimalResponse save(AnimalRequest request) {
        Optional<Animal> isAnimalExist = animalRepo.findByNameAndCustomerId(request.getName(), request.getCustomerId().getId());
        if (isAnimalExist.isEmpty()) {
            Customer customer = customerRepo.findById(request.getCustomerId().getId()).orElseThrow(() -> new NotFoundException(Msg.notFound(request.getCustomerId().getId(), "müşteri")));
            Animal animal = new Animal();
            animal.setCustomer(customer);
            animal.setName(request.getName());
            animal.setGender(request.getGender());
            animal.setSpecies(request.getSpecies());
            animal.setBreed(request.getBreed());
            animal.setColour(request.getColour());
            animal.setDateOfBirth(request.getDateOfBirth());

            Animal animalSaved = animalRepo.save(animal);
            return animalMapper.asOutput(animalSaved);
        }

        throw new RuntimeException(Msg.IsPossibilityRegistration("hayvan"));
    }

    @Override
    public AnimalResponse getAnimalById(long id) {
        return animalMapper.asOutput(animalRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.notFound(id, "hayvan"))));
    }

    @Override
    public List<AnimalResponse> getAll(String name) {
        if(name == null || name.isEmpty()){
            return this.animalMapper.asOutput(this.animalRepo.findAll());
        }
        return this.animalMapper.asOutput(this.animalRepo.findByNameContainsIgnoreCase(name));
    }

    @Override
    public AnimalResponse update(long id, AnimalRequest request) {
        Optional<Animal> animalDateFromDb = this.animalRepo.findById(id);
        if (animalDateFromDb.isEmpty()) {
            throw new NotFoundException(Msg.notFound(id, "hayvan"));
        }

        Customer customer = customerRepo.findById(request.getCustomerId().getId()).orElseThrow(() -> new NotFoundException(Msg.notFound(request.getCustomerId().getId(), "müşteri")));
        Animal animal = animalDateFromDb.get();
        animal.setCustomer(customer);
        animal.setSpecies(request.getSpecies());
        animal.setBreed(request.getBreed());
        animal.setColour(request.getColour());
        animal.setDateOfBirth(request.getDateOfBirth());
        animal.setGender(request.getGender());
        animal.setName(request.getName());
        Animal animalSaved = animalRepo.save(animal);
        return this.animalMapper.asOutput(animalSaved);
    }

    @Override
    public void deleteById(long id) {
        Optional<Animal> animalDateFromDb = this.animalRepo.findById(id);
        if(animalDateFromDb.isPresent()) {
            this.animalRepo.delete(animalDateFromDb.get());
        }else{
            throw new NotFoundException(Msg.notFound(id, "müşteri"));
        }
    }

}
