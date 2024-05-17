package net.atmacacode.veterinarian.mapper;

import net.atmacacode.veterinarian.dto.request.animal.AnimalRequest;
import net.atmacacode.veterinarian.dto.response.animal.AnimalResponse;
import net.atmacacode.veterinarian.entities.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnimalMapper {

    Animal asEntity(AnimalRequest animalRequest);

    AnimalResponse asOutput(Animal animal);

    List<AnimalResponse> asOutput(List<Animal> animal);

    void update(@MappingTarget Animal animal, AnimalRequest animalRequest);
}
