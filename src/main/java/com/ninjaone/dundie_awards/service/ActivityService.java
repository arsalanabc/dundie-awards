package com.ninjaone.dundie_awards.service;

import com.ninjaone.dundie_awards.model.Activity;
import com.ninjaone.dundie_awards.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    public Activity createActivity(String event){
        return activityRepository.save(new Activity(LocalDateTime.now(), event));
    }
}
