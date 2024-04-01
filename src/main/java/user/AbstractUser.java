package user;

import org.springframework.lang.NonNull;
import user.enums.Gender;


public abstract class AbstractUser {
    private Long ID;
    @NonNull
    private String login;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private Gender gender;

    public abstract Builder builder();

    protected abstract static class Builder<T extends Builder<T>> {
        Long ID;
        @NonNull
        String login;
        @NonNull
        String firstName;
        @NonNull
        String lastName;
        @NonNull
        private Gender gender;

        protected abstract AbstractUser build();

        protected abstract T self();

        public T ID(Long ID) {
            this.ID = ID;
            return self();
        }
        public T firstName(@NonNull String firstName) {
            this.firstName = firstName;
            return self();
        }

        public T lastName(@NonNull String lastName) {
            this.lastName = lastName;
            return self();
        }

        public T login(@NonNull String login) {
            this.login = login;
            return self();
        }

        public T gender(@NonNull Gender gender) {
            this.gender = gender;
            return self();
        }
    }
}