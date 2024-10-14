package com.ninjaone.dundie_awards.service;

import com.ninjaone.dundie_awards.model.Organization;
import com.ninjaone.dundie_awards.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService extends BaseService<Organization> {
    public OrganizationService(BaseRepository<Organization> baseRepository) {
        super(baseRepository);
    }
}
