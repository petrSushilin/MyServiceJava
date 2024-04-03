package ru.medicaltickets.MyServiceJava.user.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value = "core.clients.pension-age-threshold")
public class ClientProperties {
    private int maleAgeThreshold;
    private int femaleAgeThreshold;

    public int maleAgeThreshold() {
        return maleAgeThreshold;
    }

    public int femaleAgeThreshold() {
        return femaleAgeThreshold;
    }
}
