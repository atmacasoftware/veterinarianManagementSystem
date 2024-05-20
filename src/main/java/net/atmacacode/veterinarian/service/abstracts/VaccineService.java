package net.atmacacode.veterinarian.service.abstracts;

import net.atmacacode.veterinarian.dto.request.vaccine.VaccineRequest;
import net.atmacacode.veterinarian.dto.response.vaccine.VaccineResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface VaccineService {
    VaccineResponse save(VaccineRequest request);

    VaccineResponse getVaccineById(long id);

    List<VaccineResponse> getAll(Long id);

    List<VaccineResponse> getDateFilter(LocalDate startDate, LocalDate endDate);

    VaccineResponse update(long id, VaccineRequest request);

    void deleteById(long id);
}
