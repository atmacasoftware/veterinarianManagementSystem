package net.atmacacode.veterinarian.controller.animal.v1;

import jakarta.validation.Valid;
import net.atmacacode.veterinarian.core.result.Result;
import net.atmacacode.veterinarian.core.result.ResultData;
import net.atmacacode.veterinarian.core.utilies.ResultHelper;
import net.atmacacode.veterinarian.dto.request.animal.AnimalRequest;
import net.atmacacode.veterinarian.dto.response.animal.AnimalResponse;
import net.atmacacode.veterinarian.service.abstracts.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/animals")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AnimalResponse> save(@Valid @RequestBody AnimalRequest animalRequest) {
        return ResultHelper.created(this.animalService.save(animalRequest));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalResponse> getById(@PathVariable int id){
        return ResultHelper.success((this.animalService.getAnimalById(id)));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AnimalResponse>> getAlll(@RequestParam(required = false) String name){
        if(name == null || name.isEmpty()){
            return ResultHelper.list(this.animalService.getAll(null));
        }
        return ResultHelper.list(this.animalService.getAll(name));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalResponse> update(@PathVariable Long id, @Valid @RequestBody AnimalRequest request){
        return ResultHelper.success(this.animalService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable long id){
        this.animalService.deleteById(id);
        return ResultHelper.ok();
    }

}
