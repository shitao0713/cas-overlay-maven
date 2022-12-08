//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.apereo.cas.config;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.configuration.model.support.redis.AuditRedisProperties;
import org.apereo.cas.redis.core.RedisObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.SpringSessionRedisConnectionFactory;


@EnableConfigurationProperties({CasConfigurationProperties.class})
public class RedisConfiguration {
    public RedisConfiguration() {
    }

    @Autowired
    private CasConfigurationProperties casProperties;


    @Bean
    @SpringSessionRedisConnectionFactory
    @ConditionalOnMissingBean(
            name = {"redisConnectionFactory"}
    )
    public RedisConnectionFactory redisConnectionFactory() {
        AuditRedisProperties redis = this.casProperties.getAudit().getRedis();
        return RedisObjectFactory.newRedisConnectionFactory(redis);
    }

}
