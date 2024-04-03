package ru.medicaltickets.MyServiceJava.user.account;

import org.springframework.lang.NonNull;

public record Account(Long id, String login, char[] password) {
    public static Account.Builder builder() {
        return new Account.Builder();
    }

    public static class Builder {
        private Long ID;
        @NonNull
        private String login;
        @NonNull
        private char[] password;

        public Account build() {
            return new Account(ID, login, password);
        }

        public Account.Builder self() {
            return this;
        }

        public Account.Builder ID(Long ID) {
            this.ID = ID;
            return self();
        }

        public Account.Builder login(String login) {
            this.login = login;
            return self();
        }

        public Account.Builder password(char[] password) {
            this.password = password;
            return self();
        }
    }
}
