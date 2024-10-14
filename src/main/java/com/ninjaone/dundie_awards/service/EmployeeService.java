package com.ninjaone.dundie_awards.service;

import com.ninjaone.dundie_awards.AwardsCache;
import com.ninjaone.dundie_awards.dto.PublishActivityDTO;
import com.ninjaone.dundie_awards.enums.DundieAward;
import com.ninjaone.dundie_awards.model.Employee;
import com.ninjaone.dundie_awards.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends BaseService<Employee> {
    @Autowired
    AwardsCache awardsCache;

    @Autowired
    ActivityService activityService;

    public EmployeeService(BaseRepository<Employee> baseRepository) {
        super(baseRepository);
    }

    public void giveAward(Long id, DundieAward awardType) {
        Employee employee = this.get(id).orElseThrow();
        employee.setDundieAwards(employee.getDundieAwards()+1);
        this.update(employee);

        awardsCache.addOneAward(employee.getOrganization().getId());

        publishActivity(new PublishActivityDTO(employee, awardType));
    }

    private void publishActivity(PublishActivityDTO activity){
        String activityEvent = activity.em().getFirstName()+" "+activity.em().getLastName()+
                " from "+ activity.em().getOrganization().getName() +
                " is awarded "+ activity.award().getDisplayName();
        activityService.createActivity(activityEvent);
    }
}
