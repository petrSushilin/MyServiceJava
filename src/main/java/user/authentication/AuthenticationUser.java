package user.authentication;

import org.springframework.lang.NonNull;

public record AuthenticationInfo(Long id, String login, char[] password) {
    public AuthenticationInfo.Builder builder() {
        return new AuthenticationInfo.Builder();
    }

    public static class Builder {
        private Long ID;
        @NonNull
        private String login;
        @NonNull
        private char[] password;

        public AuthenticationInfo build() {
            return new AuthenticationInfo(ID, login, password);
        }

        public AuthenticationInfo.Builder self() {
            return this;
        }

        public AuthenticationInfo.Builder ID(Long ID) {
            this.ID = ID;
            return self();
        }

        public AuthenticationInfo.Builder login(String login) {
            this.login = login;
            return self();
        }

        public AuthenticationInfo.Builder password(char[] password) {
            this.password = password;
            return self();
        }
    }
}
