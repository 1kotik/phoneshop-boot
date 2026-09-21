package com.expertsoft.phoneshop.controller.page;

import com.expertsoft.phoneshop.config.PhoneShopProperties;
import com.expertsoft.phoneshop.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import static com.expertsoft.phoneshop.PhoneShopConstants.ADMIN_PATH;

@Controller
@RequestMapping(ADMIN_PATH)
public class AdminPageController {
    private static final String ADMIN_PAGE = "admin/adminPanelPage";
    private static final String USER_ATTRIBUTE = "users";
    private static final String PLP_MAX_PAGES = "plpMaxPages";

    @Resource
    private UserService userService;
    @Resource
    private PhoneShopProperties phoneShopProperties;

    @GetMapping
    public String getAdminPage(
            @PageableDefault Pageable pageRequest,
            Model model) {
        model.addAttribute(USER_ATTRIBUTE, userService.getUsersPage(pageRequest));
        model.addAttribute(PLP_MAX_PAGES, phoneShopProperties.getPlpMaxPages());
        return ADMIN_PAGE;
    }
}
