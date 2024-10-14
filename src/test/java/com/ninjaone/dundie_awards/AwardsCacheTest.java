package com.ninjaone.dundie_awards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AwardsCacheTest {
    private AwardsCache awardsCache;

    @BeforeEach
    public void setUp() {
        awardsCache = new AwardsCache();
    }

    @Test
    public void testSetTotalAwards() {
        Long organizationId = 1L;
        int totalAwards = 5;

        int returnedAwards = awardsCache.setTotalAwards(organizationId, totalAwards);
        assertEquals(totalAwards, returnedAwards, "Returned total awards should match the set value");

        int retrievedAwards = awardsCache.getTotalAwards(organizationId);
        assertEquals(totalAwards, retrievedAwards, "Retrieved total awards should match the set value");
    }

    @Test
    public void testGetTotalAwards_DefaultValue() {
        Long organizationId = 2L;

        int retrievedAwards = awardsCache.getTotalAwards(organizationId);
        assertEquals(0, retrievedAwards, "Awards for a non-existent organization should be 0 by default");
    }

    @Test
    public void testAddOneAward() {
        Long organizationId = 3L;

        int newTotalAwards = awardsCache.addOneAward(organizationId);
        assertEquals(1, newTotalAwards, "Total awards should be 1 after adding one award");

        newTotalAwards = awardsCache.addOneAward(organizationId);
        assertEquals(2, newTotalAwards, "Total awards should be 2 after adding another award");

        int retrievedAwards = awardsCache.getTotalAwards(organizationId);
        assertEquals(2, retrievedAwards, "Retrieved awards should reflect the updated value after increments");
    }

    @Test
    public void testSetTotalAwards_Overwrite() {
        Long organizationId = 4L;
        int initialAwards = 3;
        int updatedAwards = 10;

        awardsCache.setTotalAwards(organizationId, initialAwards);
        int retrievedAwards = awardsCache.getTotalAwards(organizationId);
        assertEquals(initialAwards, retrievedAwards, "Retrieved awards should match initially set value");

        awardsCache.setTotalAwards(organizationId, updatedAwards);
        retrievedAwards = awardsCache.getTotalAwards(organizationId);
        assertEquals(updatedAwards, retrievedAwards, "Retrieved awards should match updated value");
    }
}
