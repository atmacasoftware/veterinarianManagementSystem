package net.atmacacode.veterinarian.service.abstracts;


import net.atmacacode.veterinarian.dto.request.animal.AnimalRequest;
import net.atmacacode.veterinarian.dto.response.animal.AnimalResponse;

import java.util.List;

public interface AnimalService {
    AnimalResponse save(AnimalRequest request);

    AnimalResponse getAnimalById(long id);

    List<AnimalResponse> getAll(String name);

    List<AnimalResponse> getAllAnimalsByCustomer(long id);

    AnimalResponse update(long id, AnimalRequest request);

    void deleteById(long id);
}
