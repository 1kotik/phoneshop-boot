package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.dto.PhoneDto;
import com.expertsoft.phoneshop.dto.SearchParametersData;
import com.expertsoft.phoneshop.persistence.model.Phone;
import com.expertsoft.phoneshop.persistence.repository.PhoneRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.NoSuchElementException;

@Service
public class PhoneService {
    @Resource
    private PhoneRepository phoneRepository;

    public Page<PhoneDto> getPhonesPage(Pageable pageRequest, SearchParametersData searchParameters) {
        Page<Phone> phonePage = phoneRepository.searchByParameters(
                pageRequest,
                searchParameters.getName(),
                searchParameters.getFromPrice(),
                searchParameters.getToPrice());
        return phonePage.map(PhoneDto::new);
    }

    public PhoneDto getPhoneForId(Long id) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        return new PhoneDto(phone);
    }
}
