package net.atmacacode.veterinarian.mapper;

import net.atmacacode.veterinarian.dto.request.customer.CustomerRequest;
import net.atmacacode.veterinarian.dto.response.customer.CustomerResponse;
import net.atmacacode.veterinarian.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    Customer asEntity(CustomerRequest customerRequest);

    CustomerResponse asOutput(Customer customer);

    List<CustomerResponse> asOutput(List<Customer> customer);

    void update(@MappingTarget Customer customer, CustomerRequest customerRequest);
}
