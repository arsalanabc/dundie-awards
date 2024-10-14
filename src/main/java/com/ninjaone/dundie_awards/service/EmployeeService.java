package com.ninjaone.dundie_awards.service;

import com.ninjaone.dundie_awards.model.Employee;
import com.ninjaone.dundie_awards.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends BaseService<Employee> {

    public EmployeeService(BaseRepository<Employee> baseRepository) {
        super(baseRepository);
    }
}
