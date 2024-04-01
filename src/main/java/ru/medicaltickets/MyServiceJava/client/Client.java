package ru.medicaltickets.MyServiceJava.client;

import org.springframework.lang.NonNull;
import ru.medicaltickets.MyServiceJava.global.abstracts.AbstractSubject;

import java.util.Date;

public class Client extends AbstractSubject {
    @NonNull
    private Date dateOfBirthday;

    public Client.Builder builder() {
        return new Client.Builder();
    }

    public static class Builder extends AbstractSubject.Builder<Builder> {
        @NonNull
        private Date dateOfBirthday;

        @Override
        public Client build() {
            Client client = new Client();
            client.dateOfBirthday = dateOfBirthday;
            return client;
        }

        @Override
        protected Client.Builder self() {
            return this;
        }

        public Client.Builder dateOfBirthday(Date dateOfBirthday) {
            this.dateOfBirthday = dateOfBirthday;
            return this;
        }
    }
}
