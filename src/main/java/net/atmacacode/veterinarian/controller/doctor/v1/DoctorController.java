package net.atmacacode.veterinarian.controller.doctor.v1;

import jakarta.validation.Valid;
import net.atmacacode.veterinarian.core.result.Result;
import net.atmacacode.veterinarian.core.result.ResultData;
import net.atmacacode.veterinarian.core.utilies.ResultHelper;
import net.atmacacode.veterinarian.dto.request.doctor.DoctorRequest;
import net.atmacacode.veterinarian.dto.response.doctor.DoctorResponse;
import net.atmacacode.veterinarian.service.abstracts.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<DoctorResponse> save(@Valid @RequestBody DoctorRequest doctorRequest) {
        return ResultHelper.created(this.doctorService.save(doctorRequest));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DoctorResponse> getById(@PathVariable Long id) {
        return ResultHelper.success(this.doctorService.getUserById(id));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<DoctorResponse>> getAll() {
        return ResultHelper.list(doctorService.getAll());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DoctorResponse> update(@PathVariable Long id, @Valid @RequestBody DoctorRequest request){
        return ResultHelper.created(this.doctorService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable long id){
        this.doctorService.deleteById(id);
        return ResultHelper.ok();
    }

}
