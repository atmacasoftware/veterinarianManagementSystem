package net.atmacacode.veterinarian.service.impl;

import net.atmacacode.veterinarian.core.exception.NotFoundException;
import net.atmacacode.veterinarian.core.utilies.Msg;
import net.atmacacode.veterinarian.dao.CustomerRepo;
import net.atmacacode.veterinarian.dto.request.customer.CustomerRequest;
import net.atmacacode.veterinarian.dto.response.customer.CustomerResponse;
import net.atmacacode.veterinarian.entities.Customer;
import net.atmacacode.veterinarian.mapper.AnimalMapper;
import net.atmacacode.veterinarian.mapper.CustomerMapper;
import net.atmacacode.veterinarian.service.abstracts.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    public CustomerImpl(CustomerRepo customerRepo, CustomerMapper customerMapper, AnimalMapper animalMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponse save(CustomerRequest request) {
        Optional<Customer> isCustomerExist = customerRepo.findByMail(request.getMail());
        if(isCustomerExist.isEmpty()){
            Customer customerSaved = customerRepo.save(customerMapper.asEntity(request));
            return customerMapper.asOutput(customerSaved);
        }
        throw new RuntimeException(Msg.IsPossibilityRegistration("müşteri"));
    }

    @Override
    public CustomerResponse getUserById(long id) {
        return customerMapper.asOutput(customerRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.notFound(id, "müşteri"))));
    }

    @Override
    public List<CustomerResponse> getAll(String name) {
        if(name == null || name.isEmpty()){
            return customerMapper.asOutput(customerRepo.findAll());
        }
        return customerMapper.asOutput(customerRepo.findByNameContainsIgnoreCase(name));
    }

    @Override
    public CustomerResponse update(long id, CustomerRequest request) {
        Optional<Customer> isCustomerExist = customerRepo.findById(id);
        if(isCustomerExist.isEmpty()){
            throw new NotFoundException(Msg.notFound(id, "id"));
        }
        Customer customer = isCustomerExist.get();
        customerMapper.update(customer, request);
        return customerMapper.asOutput(customerRepo.save(customer));
    }

    @Override
    public void deleteById(long id) {
        Optional<Customer> isCustomerExist = customerRepo.findById(id);
        if(isCustomerExist.isPresent()){
            customerRepo.delete(isCustomerExist.get());
        }else{
            throw new NotFoundException(Msg.notFound(id, "id"));
        }
    }
}
