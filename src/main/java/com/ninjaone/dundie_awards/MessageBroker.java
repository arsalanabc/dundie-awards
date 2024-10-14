package com.ninjaone.dundie_awards;

import com.ninjaone.dundie_awards.model.Activity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class MessageBroker {

    @Value("${message_broker_url}")
    String url;

    RestTemplate restTemplate = new RestTemplate();

    public void sendMessage(Activity message) {
        restTemplate.postForObject( url+"/messages", message, Activity.class);
    }

    public List<Activity> getMessages(){
        return restTemplate.getForObject( url+"/messages", List.class);
    }
}
