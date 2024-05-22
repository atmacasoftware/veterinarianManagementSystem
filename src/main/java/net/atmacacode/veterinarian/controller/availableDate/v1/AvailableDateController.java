package net.atmacacode.veterinarian.controller.availableDate.v1;

import jakarta.validation.Valid;
import net.atmacacode.veterinarian.core.result.Result;
import net.atmacacode.veterinarian.core.result.ResultData;
import net.atmacacode.veterinarian.core.utilies.ResultHelper;
import net.atmacacode.veterinarian.dto.request.availableDate.AvailableDateRequest;
import net.atmacacode.veterinarian.dto.response.availableDate.AvailableDateResponse;
import net.atmacacode.veterinarian.service.abstracts.AvailableDateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/available-dates")
public class AvailableDateController {
    private final AvailableDateService availableDateService;

    public AvailableDateController(AvailableDateService availableDateService) {
        this.availableDateService = availableDateService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AvailableDateResponse> save(@Valid @RequestBody AvailableDateRequest availableDateRequest) {
        return ResultHelper.created(this.availableDateService.save(availableDateRequest));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AvailableDateResponse> getById(@PathVariable int id){
        return ResultHelper.success((this.availableDateService.getAvailableDateById(id)));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AvailableDateResponse>> getAll(){
        return ResultHelper.list(this.availableDateService.getAll());
    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AvailableDateResponse>> getFilter(@RequestParam Long doctorId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return ResultHelper.list(this.availableDateService.getFilter(doctorId, startDate, endDate));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AvailableDateResponse> update(@PathVariable Long id, @Valid @RequestBody AvailableDateRequest request){
        return ResultHelper.success(this.availableDateService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable long id){
        this.availableDateService.deleteById(id);
        return ResultHelper.ok();
    }

}
