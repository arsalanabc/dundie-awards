package com.ninjaone.dundie_awards.controller;

import com.ninjaone.dundie_awards.model.Employee;
import com.ninjaone.dundie_awards.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // use RestController to let spring handle the response types
@RequestMapping("/employees")
public class EmployeeController extends BaseController<Employee> {
    public EmployeeController(BaseService<Employee> baseService) {
        super(baseService);
    }
}