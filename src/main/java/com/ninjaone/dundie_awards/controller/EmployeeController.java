package com.ninjaone.dundie_awards.controller;

import com.ninjaone.dundie_awards.enums.DundieAward;
import com.ninjaone.dundie_awards.model.Employee;
import com.ninjaone.dundie_awards.service.BaseService;
import com.ninjaone.dundie_awards.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // use RestController to let spring handle the response types
@RequestMapping("/employees")
public class EmployeeController extends BaseController<Employee> {

    @Autowired
    EmployeeService employeeService;
    public EmployeeController(BaseService<Employee> baseService) {
        super(baseService);
    }

    @PutMapping("/{id}/award/{awardType}")
    public void giveAnAward(@PathVariable Long id, @PathVariable DundieAward awardType){
        this.employeeService.giveAward(id, awardType);
    }
}