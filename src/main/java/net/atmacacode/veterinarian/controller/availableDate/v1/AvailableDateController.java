package net.atmacacode.veterinarian.controller.availableDate.v1;

import jakarta.validation.Valid;
import net.atmacacode.veterinarian.core.config.modelMapper.IModelMapperService;
import net.atmacacode.veterinarian.core.result.Result;
import net.atmacacode.veterinarian.core.result.ResultData;
import net.atmacacode.veterinarian.core.utilies.ResultHelper;
import net.atmacacode.veterinarian.dto.request.availableDate.AvailableDateSaveRequest;
import net.atmacacode.veterinarian.dto.request.availableDate.AvailableDateUpdateRequest;
import net.atmacacode.veterinarian.dto.response.CursorResponse;
import net.atmacacode.veterinarian.dto.response.availableDate.AvailableDateResponse;
import net.atmacacode.veterinarian.entities.AvailableDate;
import net.atmacacode.veterinarian.service.abstracts.IAvailableDateService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v1/available-dates")
public class AvailableDateController {
    private final IAvailableDateService availableDateService;
    private final IModelMapperService modelMapper;

    public AvailableDateController(IAvailableDateService availableDateService, IModelMapperService modelMapper) {
        this.availableDateService = availableDateService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AvailableDateResponse> save(@Valid @RequestBody AvailableDateSaveRequest availableDateSaveRequest) {
        AvailableDate availableDate = this.modelMapper.forRequest().map(availableDateSaveRequest, AvailableDate.class);
        this.availableDateService.save(availableDate);
        return ResultHelper.created(this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AvailableDateResponse> getById(@PathVariable int id){
        return ResultHelper.success(this.modelMapper.forResponse().map(this.availableDateService.getAvailableDateById(id), AvailableDateResponse.class));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AvailableDateResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        Page<AvailableDate> availableDatePage = this.availableDateService.cursor(page, pageSize);
        Page<AvailableDateResponse> availableDateResponse = availableDatePage.map(availableDate -> this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class));
        return ResultHelper.cursor(availableDateResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AvailableDateResponse> update(@Valid @RequestBody AvailableDateUpdateRequest availableDateUpdateRequest){
        AvailableDate updateAvailableDate = this.modelMapper.forRequest().map(availableDateUpdateRequest, AvailableDate.class);
        this.availableDateService.update(updateAvailableDate);
        return ResultHelper.created(this.modelMapper.forResponse().map(updateAvailableDate, AvailableDateResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable int id){
        this.availableDateService.delete(id);
        return ResultHelper.ok();
    }


}
