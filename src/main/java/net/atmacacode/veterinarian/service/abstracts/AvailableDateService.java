package net.atmacacode.veterinarian.service.abstracts;

import net.atmacacode.veterinarian.dto.request.availableDate.AvailableDateRequest;
import net.atmacacode.veterinarian.dto.response.availableDate.AvailableDateResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AvailableDateService {
    AvailableDateResponse save(AvailableDateRequest request);

    AvailableDateResponse getAvailableDateById(long id);

    List<AvailableDateResponse> getAll();

    AvailableDateResponse update(long id, AvailableDateRequest request);

    void deleteById(long id);
}
