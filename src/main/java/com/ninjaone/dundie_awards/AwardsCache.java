package com.ninjaone.dundie_awards;

import com.ninjaone.dundie_awards.dto.AwardsRecordDTO;
import com.ninjaone.dundie_awards.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@CacheConfig(cacheNames = "awards")
public class AwardsCache {
    private Map<Long, AwardsRecordDTO> awardsRecord = new HashMap<>();

    @CachePut( key = "#organizationId")
    public int setTotalAwards(Long organizationId, int totalAwards) {
        this.awardsRecord.put(organizationId ,new AwardsRecordDTO(organizationId, totalAwards));
        return totalAwards;
    }

    @Cacheable(key = "#organizationId")
    public int getTotalAwards(Long organizationId){
        return this.awardsRecord.getOrDefault(organizationId, new AwardsRecordDTO(organizationId, 0)).totalAwards();
    }

    @CachePut(key = "#organizationId")
    public int addOneAward(Long organizationId){
        this.awardsRecord.put(organizationId, new AwardsRecordDTO(organizationId, this.getTotalAwards(organizationId)+1));
        return this.getTotalAwards(organizationId);
    }

}
