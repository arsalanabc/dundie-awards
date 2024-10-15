package com.ninjaone.dundie_awards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableCaching
@Profile({"main_app", "broker"})
public class DundieAwardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DundieAwardsApplication.class, args);
	}

	@Bean
	public RedisCacheConfiguration cacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofMinutes(60))
				.disableCachingNullValues()
				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
	}

}
