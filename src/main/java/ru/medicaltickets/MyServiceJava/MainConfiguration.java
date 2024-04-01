package ru.medicaltickets.MyServiceJava;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import user.client.ClientConfiguration;
import ru.medicaltickets.MyServiceJava.clinic.ClinicConfiguration;
import user.doctor.DoctorConfiguration;
import ru.medicaltickets.MyServiceJava.ticket.TicketConfiguration;

import javax.sql.DataSource;

@Import({
        ClientConfiguration.class,
        DoctorConfiguration.class,
        ClinicConfiguration.class,
        TicketConfiguration.class
})
@Configuration
public class MainConfiguration {
    @Bean
    public DataSourceConnectionProvider dataSourceConnectionProvider(DataSource dataSource) {
        return new DataSourceConnectionProvider(dataSource);
    }

    @Bean
    public DefaultConfiguration defaultConfiguration(DataSourceConnectionProvider dataSourceConnectionProvider) {
        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.setSQLDialect(SQLDialect.POSTGRES);
        configuration.setSystemConnectionProvider(dataSourceConnectionProvider);
        return configuration;
    }

    @Bean
    public DSLContext context(DefaultConfiguration configuration) {
        return new DefaultDSLContext(configuration);
    }
}
