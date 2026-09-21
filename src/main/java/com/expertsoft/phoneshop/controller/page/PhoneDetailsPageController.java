package com.expertsoft.phoneshop.controller.page;

import com.expertsoft.phoneshop.dto.PhoneDto;
import com.expertsoft.phoneshop.service.PhoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import java.util.NoSuchElementException;

import static com.expertsoft.phoneshop.PhoneShopConstants.PHONES_PATH;

@Controller
@RequestMapping(PHONES_PATH)
public class PhoneDetailsPageController {

    private static final String PHONE_DETAILS_PAGE = "phoneDetailsPage";
    private static final String ERROR_PAGE = "error";
    private static final String PHONE = "phone";
    private static final String ERROR_MESSAGE = "errorMessage";

    @Resource
    private PhoneService phoneService;

    @GetMapping( "/{phoneId}")
    public String getPhoneDetails(
            @PathVariable("phoneId") Long phoneId,
            Model model) {
        PhoneDto phone = phoneService.getPhoneForId(phoneId);
        model.addAttribute(PHONE, phone);
        return PHONE_DETAILS_PAGE;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoSuchElementException(Model model) {
        model.addAttribute(ERROR_MESSAGE, "Phone not found");
        return ERROR_PAGE;
    }
}
