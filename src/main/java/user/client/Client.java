package user.client;

import org.springframework.lang.NonNull;
import user.AbstractUser;

import java.util.Date;

public class Client extends AbstractUser {
    @NonNull
    private Date dateOfBirthday;

    public Client.Builder builder() {
        return new Client.Builder();
    }

    public static class Builder extends AbstractUser.Builder<Builder> {
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
