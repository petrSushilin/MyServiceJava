package ru.medicaltickets.MyServiceJava.user;

import jakarta.validation.constraints.Pattern;
import org.springframework.lang.NonNull;
import ru.medicaltickets.MyServiceJava.user.enums.Gender;


public abstract class AbstractUser {
    private Long ID;
    @NonNull
    private Long accountID;
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]")
    @NonNull
    private String firstName;
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]")
    @NonNull
    private String lastName;
    @NonNull
    private Gender gender;

    public static Builder builder() {
        return null;
    }

    public Long getID() {
        return this.ID;
    }

    protected abstract static class Builder<T extends Builder<T>> {
        Long ID;
        @NonNull
        Long accountID;
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
        public T accountID(@NonNull Long accountID) {
            this.accountID = accountID;
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

        public T gender(@NonNull Gender gender) {
            this.gender = gender;
            return self();
        }
    }
}