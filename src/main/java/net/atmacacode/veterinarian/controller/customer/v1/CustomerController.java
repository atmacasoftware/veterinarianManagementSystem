package net.atmacacode.veterinarian.controller.customer.v1;

import jakarta.validation.Valid;
import net.atmacacode.veterinarian.core.result.Result;
import net.atmacacode.veterinarian.core.result.ResultData;
import net.atmacacode.veterinarian.core.utilies.ResultHelper;
import net.atmacacode.veterinarian.dto.request.customer.CustomerRequest;
import net.atmacacode.veterinarian.dto.response.customer.CustomerResponse;
import net.atmacacode.veterinarian.service.abstracts.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CustomerResponse> save(@Valid @RequestBody CustomerRequest customerRequest) {
        return ResultHelper.created(customerService.save(customerRequest));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> getById(@PathVariable long id) {
        return ResultHelper.success(customerService.getUserById(id));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<CustomerResponse>> getAll(@RequestParam(required = false) String name) {
        if (name == null || name.isEmpty()) {
            return ResultHelper.list(customerService.getAll(null));
        }
        return ResultHelper.list(customerService.getAll(name));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> update(@PathVariable long id, @Valid @RequestBody CustomerRequest customerRequest) {
        return ResultHelper.created(customerService.update(id, customerRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable long id) {
        customerService.deleteById(id);
        return ResultHelper.ok();
    }

}
