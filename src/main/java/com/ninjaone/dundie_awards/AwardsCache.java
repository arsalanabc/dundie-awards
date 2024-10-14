package com.ninjaone.dundie_awards;

import com.ninjaone.dundie_awards.model.AwardsRecord;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@CacheConfig(cacheNames = "awards")
public class AwardsCache {
    private Map<Long,AwardsRecord> awardsRecord = new HashMap<>();

    @CachePut( key = "#organizationId")
    public int setTotalAwards(Long organizationId, int totalAwards) {
        this.awardsRecord.put(organizationId ,new AwardsRecord(organizationId, totalAwards));
        return totalAwards;
    }

    @Cacheable(key = "#organizationId")
    public int getTotalAwards(Long organizationId){
        return this.awardsRecord.getOrDefault(organizationId, new AwardsRecord(organizationId, 0)).totalAwards();
    }

    @CachePut(key = "#organizationId")
    public int addOneAward(Long organizationId){
        this.awardsRecord.put(organizationId, new AwardsRecord(organizationId, this.getTotalAwards(organizationId)+1));
        return this.getTotalAwards(organizationId);
    }

}
