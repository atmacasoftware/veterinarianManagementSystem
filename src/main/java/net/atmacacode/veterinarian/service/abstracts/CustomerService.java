package net.atmacacode.veterinarian.service.abstracts;

import net.atmacacode.veterinarian.dto.request.customer.CustomerRequest;
import net.atmacacode.veterinarian.dto.response.animal.AnimalResponse;
import net.atmacacode.veterinarian.dto.response.customer.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerResponse save(CustomerRequest request);

    CustomerResponse getUserById(long id);

    List<CustomerResponse> getAll(String name);

    CustomerResponse update(long id, CustomerRequest request);

    void deleteById(long id);
}
