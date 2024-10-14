package com.ninjaone.dundie_awards.controller;

import com.ninjaone.dundie_awards.model.Organization;
import com.ninjaone.dundie_awards.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // use RestController to let spring handle the response types
@RequestMapping("/organizations")
public class OrganizationController extends BaseController<Organization> {
    public OrganizationController(BaseService<Organization> baseService) {
        super(baseService);
    }
}