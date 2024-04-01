package user.authentication;

import org.springframework.lang.NonNull;

public record AuthenticationUser(Long id, String login, char[] password) {
    public AuthenticationUser.Builder builder() {
        return new AuthenticationUser.Builder();
    }

    public static class Builder {
        private Long ID;
        @NonNull
        private String login;
        @NonNull
        private char[] password;

        public AuthenticationUser build() {
            return new AuthenticationUser(ID, login, password);
        }

        public AuthenticationUser.Builder self() {
            return this;
        }

        public AuthenticationUser.Builder ID(Long ID) {
            this.ID = ID;
            return self();
        }

        public AuthenticationUser.Builder login(String login) {
            this.login = login;
            return self();
        }

        public AuthenticationUser.Builder password(char[] password) {
            this.password = password;
            return self();
        }
    }
}
