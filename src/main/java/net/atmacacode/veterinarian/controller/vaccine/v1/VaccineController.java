package net.atmacacode.veterinarian.controller.vaccine.v1;

import jakarta.validation.Valid;
import net.atmacacode.veterinarian.core.result.Result;
import net.atmacacode.veterinarian.core.result.ResultData;
import net.atmacacode.veterinarian.core.utilies.ResultHelper;
import net.atmacacode.veterinarian.dto.request.vaccine.VaccineRequest;
import net.atmacacode.veterinarian.dto.response.vaccine.VaccineResponse;
import net.atmacacode.veterinarian.service.abstracts.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/vaccines")
public class VaccineController {
    private final VaccineService vaccineService;

    @Autowired
    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<VaccineResponse> save(@Valid @RequestBody VaccineRequest vaccineRequest) {
        return ResultHelper.created(vaccineService.save(vaccineRequest));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<VaccineResponse> getById(@PathVariable int id){
        return ResultHelper.success((this.vaccineService.getVaccineById(id)));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<VaccineResponse>> getAll(@RequestParam(required = false) Long animalID){
        if(animalID != null){
            return ResultHelper.list(this.vaccineService.getAll(animalID));
        }
        return ResultHelper.list(this.vaccineService.getAll(null));
    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<VaccineResponse>> getDateFilter(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return ResultHelper.list(this.vaccineService.getDateFilter(startDate, endDate));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<VaccineResponse> update(@PathVariable Long id, @Valid @RequestBody VaccineRequest request){
        return ResultHelper.success(this.vaccineService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable long id){
        this.vaccineService.deleteById(id);
        return ResultHelper.ok();
    }

}
