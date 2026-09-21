package com.expertsoft.phoneshop.controller.page;

import com.expertsoft.phoneshop.config.PhoneShopProperties;
import com.expertsoft.phoneshop.dto.PhoneDto;
import com.expertsoft.phoneshop.dto.SearchParametersData;
import com.expertsoft.phoneshop.service.PhoneService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.expertsoft.phoneshop.PhoneShopConstants.PHONES_PATH;

@Controller
@RequestMapping(PHONES_PATH)
public class PhoneListPageController {

    private static final String PHONE_LIST_PAGE = "phoneListPage";
    private static final String PHONES = "phones";
    private static final String PLP_MAX_PAGES = "plpMaxPages";
    private static final String PARAMETERS_MAP = "parametersMap";
    private static final String CURRENT_SORT = "currentSort";
    private static final String ERROR_MESSAGE = "errorMessage";

    @Resource
    private PhoneShopProperties phoneShopProperties;
    @Resource
    private PhoneService phoneService;

    @GetMapping
    public String getPhoneList(
            Model model,
            @PageableDefault(sort = "brand") Pageable pageRequest,
            @Valid SearchParametersData searchParameters,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return processErrorsAndReturnEmptyPage(bindingResult, model);
        }
        Page<PhoneDto> phones = phoneService.getPhonesPage(pageRequest, searchParameters);
        Sort.Order currentSort = phones.getPageable().getSort().get().findFirst()
                .orElse(new Sort.Order(Sort.Direction.ASC, "brand"));
        model.addAttribute(PHONES, phones);
        model.addAttribute(PLP_MAX_PAGES, phoneShopProperties.getPlpMaxPages());
        model.addAttribute(PARAMETERS_MAP, createMapFromSearchParameters(searchParameters));
        model.addAttribute(CURRENT_SORT, currentSort);
        return PHONE_LIST_PAGE;
    }

    private String processErrorsAndReturnEmptyPage(BindingResult bindingResult, Model model) {
        String errorMessage = bindingResult.getAllErrors().stream()
                .map(this::formatErrorMessage)
                .distinct()
                .collect(Collectors.joining("<br>"));
        model.addAttribute(ERROR_MESSAGE, errorMessage);
        return PHONE_LIST_PAGE;
    }

    private String formatErrorMessage(ObjectError error) {
        if ("typeMismatch".equals(error.getCode())
                && error instanceof FieldError) {
            FieldError fieldError = (FieldError) error;
            return String.format("%s must be a number", fieldError.getField());
        }
        return error.getDefaultMessage();
    }

    private Map<String, Object> createMapFromSearchParameters(SearchParametersData searchParameters) {
        Map<String, Object> searchParametersMap = new HashMap<>();
        putEntryIfValueNotNull(searchParametersMap, "name", searchParameters.getName());
        putEntryIfValueNotNull(searchParametersMap, "fromPrice", searchParameters.getFromPrice());
        putEntryIfValueNotNull(searchParametersMap, "toPrice", searchParameters.getToPrice());
        return searchParametersMap;
    }

    private void putEntryIfValueNotNull(Map<String, Object> map, String key, Object value) {
        if (value != null) {
            map.put(key, value);
        }
    }
}
