package net.atmacacode.veterinarian.controller.appointment.v1;

import jakarta.validation.Valid;
import net.atmacacode.veterinarian.core.result.Result;
import net.atmacacode.veterinarian.core.result.ResultData;
import net.atmacacode.veterinarian.core.utilies.ResultHelper;
import net.atmacacode.veterinarian.dto.request.appointment.AppointmentRequest;
import net.atmacacode.veterinarian.dto.response.appointment.AppointmentResponse;
import net.atmacacode.veterinarian.service.abstracts.AppointmentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AppointmentResponse> save(@Valid @RequestBody AppointmentRequest appointmentRequest) {
        return ResultHelper.created(this.appointmentService.save(appointmentRequest));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AppointmentResponse> getById(@PathVariable int id){
        return ResultHelper.success((this.appointmentService.getAppointmentById(id)));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AppointmentResponse>> getAll(){
        return ResultHelper.list(this.appointmentService.getAll());
    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AppointmentResponse>> getFilter(@RequestParam Long animalId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endDate){
        return ResultHelper.list(this.appointmentService.getFilter(animalId, startDate, endDate));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AppointmentResponse> update(@PathVariable Long id, @Valid @RequestBody AppointmentRequest request){
        return ResultHelper.success(this.appointmentService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable long id){
        this.appointmentService.deleteById(id);
        return ResultHelper.ok();
    }

}
