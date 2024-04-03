package ru.medicaltickets.MyServiceJava.user.client;

import org.springframework.lang.NonNull;
import ru.medicaltickets.MyServiceJava.user.AbstractUser;

import java.util.Date;

public class Client extends AbstractUser {
    @NonNull
    private Date birthDate;

    public static Client.Builder builder() {
        return new Client.Builder();
    }

    public static class Builder extends AbstractUser.Builder<Builder> {
        @NonNull
        private Date birthDate;

        @Override
        public Client build() {
            Client client = new Client();
            client.birthDate = birthDate;
            return client;
        }

        @Override
        protected Client.Builder self() {
            return this;
        }

        public Client.Builder birthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }
    }
}
