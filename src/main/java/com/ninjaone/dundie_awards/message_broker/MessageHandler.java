package com.ninjaone.dundie_awards.message_broker;

import com.ninjaone.dundie_awards.model.Activity;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@RestController
@RequestMapping("/messages")
@Profile(value = "broker")
public class MessageHandler {

    ConcurrentLinkedQueue<Activity> activityList=  new ConcurrentLinkedQueue<>();

    @GetMapping()
    public List<Activity> getActivites(){
        return activityList.stream().toList();
    }

    @PostMapping()
    public void addActivity(@RequestBody Activity activity){
        activityList.add(activity);
    }

}
