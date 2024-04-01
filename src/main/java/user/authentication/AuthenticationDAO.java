package user.authentication;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationDAO {
    private DSLContext context;

    public AuthenticationDAO(DSLContext context) {
        this.context = context;
    }
}
