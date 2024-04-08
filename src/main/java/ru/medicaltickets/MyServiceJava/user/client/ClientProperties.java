package ru.medicaltickets.MyServiceJava.user.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value = "core.clients.pension-age-threshold")
public class ClientProperties {
    private static int maleAgeThreshold;
    private static int femaleAgeThreshold;

    public static int maleAgeThreshold() {
        return maleAgeThreshold;
    }

    public static int femaleAgeThreshold() {
        return femaleAgeThreshold;
    }
}
